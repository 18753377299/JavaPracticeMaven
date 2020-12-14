package javaPractice.simple.listFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * https://mp.weixin.qq.com/s/5fZHtEFv9QN6Apu-43UdiQ
*/
public class AsList {
   public static void main(String [] args) {
     String  id = "BX11,BX12";
     String  [] ids = {"BX11","BX12"} ;
     String [] strArray = id.split(",");
     List<String> asStr = new ArrayList<String>(Arrays.asList(ids));
     for (String  str: asStr) {
    	 System.out.println("========="+str);
     }
     
   /*  第二种：将数组转换为list。
    	* （将数组中的元素转为二进制，然后添加到List中，这是最高效的方法）
    	* 数量巨大的时候优先使用   begin*/
     
     ArrayList<String> list = new ArrayList<String>(ids.length);
     Collections.addAll(list,ids);
     for (String  str: list) {
    	 System.out.println("========="+str);
     }
     /*  第二种：将数组转换为list。（这是最高效的方法） end*/
     
     
    /* 注： int[] intArray1 = new int[2];
     List<Integer> list1 = Arrays.asList(intArray1);//此处报错！！！
      答：只能用Integer[]转List<Integer>，即只能用基本数据类型的包装类型，才能直接转为List。
      Java中所有的泛型必须是引用类型.
      第二行代码，Arrays.asList()方法的入参是个引用类型的int[],那么返回值类型一定是List<int[]> ,其完整代码是：List<int[]> intsArray = Arrays.asList(intArray1);，所以编译通过，没问题。

第三行报错，因为等号两边的类型不一致，左边：List<Integer>,右边List<int[]>，所以编译时就报错。
     */
     
   }
}
