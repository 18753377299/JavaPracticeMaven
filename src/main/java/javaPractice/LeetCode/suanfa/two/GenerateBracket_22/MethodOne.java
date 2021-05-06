package javaPractice.LeetCode.suanfa.two.GenerateBracket_22;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

public class MethodOne {
    @ApiOperation(value="暴力法",
            notes="我们可以使用递归。长度为 n 的序列就是在长度为 n-1 的序列前加一个 '(' 或 ')'")
    public static List<String> generateBracketOne(int n ){
        List<String> result  = new ArrayList<>();
        generateAll(new char[2*n],0,result);
        return result;
    }

    public static void generateAll(char [] charArray,int length,List<String> result){
        if(charArray.length == length){
            if(isValid(charArray)){
                result.add(new String(charArray));
            }
        }else {
            charArray[length] ='(';
            generateAll(charArray,length+1,result);
            charArray[length] =')';
            generateAll(charArray,length+1,result);
        }
    }
    @ApiOperation(value="判断符号是否有效",
            notes = "有一个左括号加1，一个右括号减1，如果中间sum小于0，或者最后结果不等于0，那么就是false")
    public static  boolean isValid(char [] charArray){
        int sum =0;
        for (char ch: charArray){
            if(ch == '('){
                ++sum ;
            }
            if(ch == ')'){
                --sum;
            }
            if(sum<0){
                return false;
            }
        }
        return sum==0;
    }
}
