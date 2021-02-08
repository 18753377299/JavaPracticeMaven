package javaPractice.LeetCode.suanfa;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        示例 1:
        输入: 121
        输出: true
        示例 2:
        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
        示例 3:
        输入: 10
        输出: false
        解释: 从右向左读, 为 01 。因此它不是一个回文数。
        进阶:
        你能不将整数转为字符串来解决这个问题吗？*/
@Api(value="回文数")
public class Huiwenshu_9 {
    public static void main(String [] args){
        Huiwenshu_9 huiwenshu_9 =new Huiwenshu_9();
         boolean result = huiwenshu_9.isPalindrome(12321);
        System.out.println("{}===>"+result);
        boolean resultTwo = huiwenshu_9.isPalindromeTwo(1001);
        System.out.println("{}===>"+resultTwo);
    }
    /**第一种方式：*/
    public boolean isPalindrome(int x) {
        String   str = String.valueOf(x);
        String reverseResult = reverseInteger(str);
        System.out.println("{response}===>"+reverseResult+",{request}===>"+x);
        return reverseResult.equals(str);
    }

    @ApiOperation(value="将整数类型进行反转成字符串形式")
    public String reverseInteger(String   str){
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i=str.length()-1;i>=0;i--){
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    /**第二种方式：*/
    @ApiOperation(value="将整数类型求出回文数，然后和原数字进行比较")
    public boolean isPalindromeTwo(int x) {
        if (x<0){
            return false;
        }
        int m=0;
        int among = x;
        while(among>0){
            m =  m*10 + among%10;
            among = among/10;
        }
        System.out.println("{response}===>"+m+",{request}===>"+x);
        return m == x;
    }

}
