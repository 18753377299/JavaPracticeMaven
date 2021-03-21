package javaPractice.lambda.FunctionInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.*;

@Api(value="比较两个字符串的大小")
public class StringComparator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("one","two","three");
        /*正序排序*/
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list.forEach(System.out::println);
        /*倒序排序*/
        Collections.sort(list,Comparator.reverseOrder());
        list.forEach(System.out::println);

        Collections.sort(list,(o1,o2)-> {
            return o1.compareTo(o2);
        });


        int result = compareTwo("abc","abd");
        System.out.println(result);

    }
    @ApiOperation(value="从小到大排列")
    public static int compareTwo(String value1,String value2){
        int len1= value1.length();
        int len2= value2.length();
        int lim = Math.min(len1,len2);
        char [] v1 = value1.toCharArray();
        char [] v2 = value2.toCharArray();
        int k =0 ;
        while(k<lim){
            char c1 = v1[k];
            char c2= v2[k];
            if(c1!=c2){
                return c1-c2;
            }
            k++;
        }
        return len1-len2;
    }
}
