package javaPractice.lambda.Stream;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Api(value="Stream的使用")
public class StreamTest {
    public static void main(String[] args) {
        String [] reqs = new String[] {"1","2","3"};

        long count = Arrays.asList(reqs).stream().filter(x->x.length()>0).count();
        System.out.println("{}=====>"+count);


        /**方式1： 数组获取stream对象*/
        Stream<String> streamArray =  Arrays.stream(reqs);
        List tempList = streamArray.filter(x->x.length()>0).collect(Collectors.toList());
        tempList.forEach(System.out::println);

        /*注：并行方式: 比串行耗时较短*/
        long count1=  tempList.parallelStream().count();
        /*注：串行方式*/
        long count2=  tempList.stream().count();


        /**方式2： 集合获取stream对象*/
        List<String> strList = Arrays.asList(reqs);
        Stream<String> streamList = strList.stream();
        /**方式3： Stream静态方法获取stream对象*/
        Stream<String> streamOf =Stream.of(reqs);
        /**方式4：创建无限流（seed起始值，重复无限次执行的方法）
        无限流1：迭代*/
        Stream<Integer> streamIter = Stream.iterate(0,x->x+2);
        /**无限流2：生成*/
        Stream<Double> streamGen = Stream.generate(() -> Math.random());



//        centerStream();
//        endStream();
    }
    @ApiOperation(value="Stream常用中间操作方法")
    public static void centerStream(){
        //Stream常用方法（链式方法，从上往下执行，下一个方法进行处理的对象是上一个方法处理后的结果）
        Arrays.stream(new Integer[]{1, 63, 3, 7, 11, 54, 34})
                //过滤器，传入一个Predicate断言型接口实现，Stream会进行内部遍历，将保留断言返回true的元素（此处过滤保留值大于4的元素）
                .filter(x -> x > 4)
                //截断流，只获取前n个元素(此处获取满足过滤器条件的前2个元素)
                .limit(5)
                //跳过元素，跳过前n个元素，获取后面的元素，若流中的元素不足n个，则返回一个空流，与limit互补（此处取除第一个元素外的元素）
                .skip(1)
                //去除重复数据
                .distinct()
                //映射，对流内元素进行处理，可以是转换类型、获取属性值等等，传入一个Function函数型接口实现（此处对流内元素全部加5）
                .map(x -> x + 5)
                //自然排序（按照Comparable默认排序，此处为Integer从小到大排序）
                .sorted()
                //定制排序（按照Comparator自定义排序，此处处理为Integer从大到小排序）
                .sorted((x, y) -> -Integer.compare(x, y))
                //终止操作，遍历流内元素，传入一个Consumer消费型接口实现（此处简单对流内元素进行打印输出）
                .forEach(System.out::println);
    }
    @ApiOperation(value="Stream常用终止操作方法")
    public static void endStream(){
        //终止操作
        Integer[] integers = {1, 63, 3, 7, 11, 54, 34};
        List<Integer> list = Arrays.asList(integers);

        //匹配所有元素，传入一个Predicate断言型接口实现，当所有元素都满足条件时返回true，否则返回false（此处判断元素是否全部大于0）
        boolean b1 = list.stream().allMatch(x -> x > 0);

        //匹配元素，传入一个Predicate断言型接口实现，当有至少一个元素满足条件时返回true，否则返回false（此处判断元素是否全部大于0）
        boolean b2 = list.stream().anyMatch(x -> x > 0);

        //无匹配元素，传入一个Predicate断言型接口实现，没有元素满足条件时返回true，否则返回false（此处判断元素是否全部大于0）
        boolean b3 = list.stream().noneMatch(x -> x > 0);

        //匹配第一个元素
        Optional<Integer> o4 = list.stream().findFirst();

        //匹配任意一个元素
        Optional<Integer> o5 = list.stream().findAny();

        //获取流中元素个数
        long l6 = list.stream().count();

        //获取流中满足条件的最小值
        Optional<Integer> min = list.stream().min(Integer::compare);
        System.out.println("min:" + min.get());

        //获取流中满足条件的最大值
        Optional<Integer> max = list.stream().max(Integer::compare);
        System.out.println("max:" + max.get());

        //归约(将identity作为起始x，第一个元素作为y，计算结果再作为x与下一个元素进行计算，得出计算结果)
        Integer reduce = list.stream().reduce(0, (x, y) -> x + y);
        //归约（未设置起始x，因此有可能空指针，因此返回类型为Optional）
        Optional<Integer> reduce1 = list.stream().reduce(Integer::sum);

        /* 收集(将流转换为其他形式，接受一个Collector接口实现，用于给Stream中元素做汇总的方法) */
        List<Integer> collect = list.stream().collect(Collectors.toList());
        //转为hashset
        HashSet<Integer> collect1 = list.stream().collect(Collectors.toCollection(HashSet::new));
        //取平均值
        Double collect2 = list.stream().collect(Collectors.averagingInt((x) -> x));
        System.out.println("avg:" + collect2);
        //求和
        Double collect3 = list.stream().collect(Collectors.summingDouble(x -> x));
        System.out.println("sum:" + collect3);
    }
}
