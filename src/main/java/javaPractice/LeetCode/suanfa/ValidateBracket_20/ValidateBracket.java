package javaPractice.LeetCode.suanfa.ValidateBracket_20;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

@Api(value="是否是有效的括号")
public class ValidateBracket {
    static Map<Character,Character> map = new HashMap<>();
    static{
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
    }

    public static void main(String[] args) {
//        String str = "([{}])";
//        String str = "){";
//        String str = "((";
        String str = "(){}[]";

        ValidateBracket vb =new ValidateBracket();
        boolean result = vb.isValidBracketMap(str);
        System.out.println("==========>"+result);
    }
    @ApiOperation(value="方法2: 使用Map和栈进行操作")
    public boolean  isValidBracketMap(String s){
        if(""== s || null ==s){
            return false;
        }
        int n  = s.length();
        if(n%2 !=0){
            return false;
        }
        Stack stack =new Stack();
        for(int i=0;i<n;i++){
            char input = s.charAt(i);
            if(map.containsKey(input)){
                /* 左侧*/
                stack.push(input);
            }else if(stack.empty() || input!= map.get(stack.pop())){
                return false;
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }

    @ApiOperation(value="方法1: 使用枚举和栈进行操作")
    public boolean  isValidateBracket(String s){
        if(""== s || null ==s){
            return false;
        }
        int n  = s.length();
        if(n%2 !=0){
            return false;
        }
        Stack stack = new Stack();
        for (int i=0;i<n;i++){
            char input = s.charAt(i);
            if(ValidateBracket.isMatchLeft(input)){
                stack.push(input);
            }else{
                /*左侧*/
                if(stack.empty()){
                    return false;
                }
                char outPut = (char)stack.pop();
                if(!ValidateBracket.isMatch(String.valueOf(outPut),String.valueOf(input))){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }


    public static boolean  isMatchLeft(char leftChar){
        String left = String.valueOf(leftChar);
        if(BracketEnum.SmallBracket.getLeft().equals(left)){
            return true;
        }
        if(BracketEnum.MediumBracket.getLeft().equals(left)){
            return true;
        }
        if(BracketEnum.BigBracket.getLeft().equals(left)){
            return true;
        }
        return false;
    }
    public static boolean isMatch(String left,String right){
        if(BracketEnum.SmallBracket.getLeft().equals(left) &&
                BracketEnum.SmallBracket.getRight().equals(right)){
            return true;
        }
        if(BracketEnum.MediumBracket.getLeft().equals(left) &&
                BracketEnum.MediumBracket.getRight().equals(right)){
            return true;
        }
        if(BracketEnum.BigBracket.getLeft().equals(left) &&
                BracketEnum.BigBracket.getRight().equals(right)){
            return true;
        }
        return false;
    }
}


enum BracketEnum{
    SmallBracket("(",")"),
    MediumBracket("[","]"),
    BigBracket("{","}");

    private String left;
    private String right;

    BracketEnum(String left, String right) {
        this.left = left;
        this.right = right;
    }

    public String getLeft() {
        return left;
    }

    public String getRight() {
        return right;
    }
}
