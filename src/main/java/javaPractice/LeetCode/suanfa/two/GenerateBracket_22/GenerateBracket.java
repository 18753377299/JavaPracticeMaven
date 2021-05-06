package javaPractice.LeetCode.suanfa.two.GenerateBracket_22;

import io.swagger.annotations.Api;

import java.util.List;

/**
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
        示例 1：
        输入：n = 3
        输出：["((()))","(()())","(())()","()(())","()()()"]
        示例 2：
        输入：n = 1
        输出：["()"]
 提示：
 1 <= n <= 8
 */
@Api(value="22. 括号生成")
public class GenerateBracket {
    public static void main(String[] args) {
        int n = 1;
        List<String> result = MethodOne.generateBracketOne(n);
        System.out.println(result.toString());

        List<String> resultTwo =MethodTwo.generateBracketTwo(n);
        System.out.println(resultTwo.toString());
    }

}
