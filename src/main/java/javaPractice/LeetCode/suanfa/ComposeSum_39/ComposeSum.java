package javaPractice.LeetCode.suanfa.ComposeSum_39;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

/** 39. 组合总和
    给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    candidates 中的数字可以无限制重复被选取。
    说明：
    所有数字（包括 target）都是正整数。
    解集不能包含重复的组合。
    示例 1：
    输入：candidates = [2,3,6,7], target = 7,
    所求解集为：
    [
    [7],
    [2,2,3]
    ]
    示例 2：
    输入：candidates = [2,3,5], target = 8,
    所求解集为：
    [
    [2,2,2,2],
    [2,3,3],
    [3,5]
    ]
         提示：
         1 <= candidates.length <= 30
         1 <= candidates[i] <= 200
         candidate 中的每个元素都是独一无二的。
         1 <= target <= 500
 */
@Api(value="组合总和")
public class ComposeSum {
    public static void main(String[] args) {
      int [] candidates = {2,3,6,7};
      int target = 7;
      ComposeSum composeSum =new ComposeSum();
      List<List<Integer>> resultList = composeSum.combinationSum(candidates,target);
      System.out.println(resultList.toString());
    }
    @ApiOperation(value="方法一：搜索回溯： 如果进行排序会减少回溯的次数",notes="尚不是太理解")
    public  List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> outSideLit = new ArrayList<>();
        List<Integer> inSideList =new ArrayList<>();
        int index = 0;
        backTrack(candidates,target,outSideLit,inSideList,index);

        return outSideLit;
    }
    public  void backTrack(int[] candidates,int target,
         List<List<Integer>> outSideList,List<Integer> inSideList,int index){
         if(candidates.length == index){
             return;
         }
         if(target == 0){
             /**相当于添加一个新的数组定义信息*/
             outSideList.add(new ArrayList<>(inSideList));
             return;
         }
         /**直接跳过*/
         backTrack(candidates,target,outSideList,inSideList,index+1);
         /**当前值*/
         if(target>=0){
             inSideList.add(Integer.valueOf(candidates[index]));
             backTrack(candidates,target-candidates[index],outSideList,inSideList,index);
             /**只有backTrack方法结束之后，才会走下面的方法，有两种情况，
             一是：已经成功添加一组数据，二是：数组遍历结束，
             那么需要去除list最后一位,进行其他可能情况的循环（看题解的图，更容易理解）*/
             inSideList.remove(inSideList.size()-1);
         }
    }

}
