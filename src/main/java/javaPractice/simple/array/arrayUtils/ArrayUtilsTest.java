package javaPractice.simple.array.arrayUtils;

import io.swagger.annotations.Api;
import org.apache.commons.lang3.ArrayUtils;


@Api(value="commons.lang3包中的ArrayUtils的方法")
public class ArrayUtilsTest {
    public static void main(String[] args) {
        String  [] str1 = new String []{"21","是"};
        String  [] str2 = new String []{"21","是"};
        System.out.println("====>数组长度是否相等:" + ArrayUtils.isSameLength(str1,str2));
        System.out.println("====>数组是否相等:" + ArrayUtils.isEquals(str1,str2));
        System.out.println("====>数组类型是否一样:" + ArrayUtils.isSameType(str1,str2));
        /**反转数组*/
        ArrayUtils.reverse(str1);
        System.out.println("====>数组反转后："+ ArrayUtils.toString(str1));
        /**进行数组的clone*/
        String [] str3 = ArrayUtils.clone(str2);
        System.out.println("===数组clone后："+ArrayUtils.toString(str3));
        /**进行数组的截取*/
        String [] str4 = ArrayUtils.subarray(str1,0,1);
        System.out.println("====>数组截取后："+ArrayUtils.toString(str4));
        /**添加一对象到数组中*/
        String [] str5 = ArrayUtils.add(str2,"333");
        System.out.println("=====>添加对象后的数组："+ArrayUtils.toString(str5));
        /**合并两个数组*/
        String  [] str6 = ArrayUtils.addAll(str1,str2);
        System.out.println("=====>合并后的数组："+ArrayUtils.toString(str6));
        /**ArrayUtils.remove 删除数组某个位置的元素*/
        System.out.println("===>删除数组中的某个位置的元素："+ArrayUtils.toString(ArrayUtils.remove(str5,2)));
        /**ArrayUtils.removeElement 删除数组中某个对象*/
        System.out.println("===>删除数组中某个元素："+ArrayUtils.toString(ArrayUtils.removeElement(str6,"是")));
    }
}
