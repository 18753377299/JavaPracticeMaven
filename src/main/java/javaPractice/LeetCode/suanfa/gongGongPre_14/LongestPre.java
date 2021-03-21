package javaPractice.LeetCode.suanfa.gongGongPre_14;

import io.swagger.annotations.Api;

/**14. 最长公共前缀:
 * 编写一个函数来查找字符串数组中的最长公共前缀。
    如果不存在公共前缀，返回空字符串 ""。
    示例 1：
    输入：strs = ["flower","flow","flight"]
    输出："fl"
    示例 2：
    输入：strs = ["dog","racecar","car"]
    输出：""
    解释：输入不存在公共前缀。
    提示：
    0 <= strs.length <= 200
    0 <= strs[i].length <= 200
    strs[i] 仅由小写英文字母组成
 */

@Api(value="最长公共前缀")
public class LongestPre {

    public static void main(String[] args) {
//       String []strs = {"flower","flow","flight"};
//        String []strs = {"cir","car"};
//        String []strs = {"ab","a"};
        String []strs = {"ab","da"};
       LongestPre longestPre =new LongestPre();
       String result = longestPre.queryCommonPre(strs);
       System.out.println("{}===>"+result);
    }

    public  String queryCommonPre(String [] strs){
        int length = strs.length;
        if(0==length){
            return "";
        }
        String result =strs[0];
        for(int i=1;i<length;i++){
            result = amongResult(strs[i],result);
        }
        return result;
    }
    public  String amongResult(String source,String target){
        int m = Math.min(source.length(),target.length());
        int index = 0;
        String result = "";
        while(index<m&&source.charAt(index) == target.charAt(index)){
            index++;
        }

//        for(int a =0;a<m;a++){
//            index = a;
//            if(source.charAt(a) != target.charAt(a)){
//                break;
////                result =target.substring(0,a+1);
//            }
//        }
        return index==0?result:target.substring(0,index);
    }

}
