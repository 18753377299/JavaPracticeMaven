package javaPractice.lambda.xunhuan;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(value="使用lambda对集合进行循环测试")
public class XunHuanTest {
    public static void main(String[] args) {
        /*测试map中foreach*/
//        testMap();
        testList();
    }
    @ApiOperation(value="测试串行和并行")
    public static void chuanBing(){
        List<String> items = new ArrayList<>();
        items.add("北京");
        items.add("天津");
        items.add("山西");
        items.add("山东");
        items.add("上海");


    }
    @ApiOperation(value="测试list中foreach")
    public static void testList(){
        List<String> items = new ArrayList<>();
        items.add("北京");
        items.add("天津");
        items.add("山西");
        items.add("山东");
        items.add("上海");

        for (String str: items){
            System.out.println("{}==>"+str);
        }
        System.out.println("-------------------------------------");
        /**方式二：*/
        items.forEach(item->{
            System.out.println("{}====>"+item);
        });
        System.out.println("-------------------------------------");
        /**方式三：*/
        items.forEach(System.out::println);
    }

    @ApiOperation(value="测试map中foreach")
    public static void testMap(){
        Map<String,String> items = new HashMap();
        items.put("北京", "京");
        items.put("天津", "津");
        items.put("山西", "晋");
        items.put("山东", "鲁");
        items.put("上海", "沪");

        /** 一般方式*/
        for(Map.Entry<String,String> map: items.entrySet()){
            System.out.println("{}==>"+map.getKey()+":"+map.getValue());
        }
        System.out.println("-------------------------------------");
        /** lambda中foreach方式*/
        items.forEach((key,value)->{
            System.out.println("{}==>"+key+":"+value);
        });

    }
}
