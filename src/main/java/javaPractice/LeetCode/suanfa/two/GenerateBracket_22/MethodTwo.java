package javaPractice.LeetCode.suanfa.two.GenerateBracket_22;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

@Api(value="回溯法")
public class MethodTwo {
    public static List<String> generateBracketTwo(int n ){
        List<String> result  = new ArrayList<>();
        backtrack(result,new StringBuilder(),0,0,n);
        return result;
    }
    @ApiOperation(value="",
            notes="如果左侧括号小于max那么就添加一个左括号，如果右侧括号小于left，那么就添加一个右侧括号")
    public static void backtrack(List<String> result,StringBuilder sb,int left,int right,int max){
        if(sb.length() == max*2){
            System.out.println("==result=>"+sb.toString());
            result.add(sb.toString());
        }
        if(left < max){
            sb.append("(");
            backtrack(result,sb,left+1,right,max);
            System.out.println("==left=>"+sb.toString()+",left:"+left+",right:"+right);
            sb.deleteCharAt(sb.length()-1);
        }
        if(right<left){
            sb.append(")");
            backtrack(result,sb,left,right+1,max);
            System.out.println("==right=>"+sb.toString()+",left:"+left+",right:"+right);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
