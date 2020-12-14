package javaPractice.LeetCode.suanfa.TwoSum_1;

import java.util.HashMap;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年11月25日 下午1:00:16
* @version 1.0
* @parameter
* 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
示例:
给定 nums = [2, 7, 11, 15], target = 9
因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]
* @since  LeetCode算法， Two-Sum
* @return  */
public class TwoSum {

public static void main(String[] args) {
    int [] nums = {4,3,3};
    int target  = 6;
    long startTime = System.currentTimeMillis();
//		int [] indexTwo = twoSum(nums,target);
    int [] indexTwo = twoSumByHash(nums,target);
    long endTime = System.currentTimeMillis();
    System.out.println("================="+(endTime-startTime));
    System.out.println("=========="+indexTwo[0]+":"+indexTwo[1]);
}

public  static int [] twoSum(int [] nums,int target){
    int [] indexTwo = new int [2];
    for (int i = 0;i<nums.length -1 ;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                indexTwo[0] = i;
                indexTwo[1]= j;
                return indexTwo;
            }
        }
    }
    return indexTwo;
}
// 通过map进行计算---
public  static int [] twoSumByHash(int [] nums,int target){
    int [] indexTwo = new int [2];
    HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
    for (int i = 0;i<nums.length ;i++){
        if(map.containsKey(nums[i])){
            indexTwo[0] = i;
            indexTwo[1] = map.get(nums[i]);
            return indexTwo;
        }
        map.put(target-nums[i], i );
    }
    return indexTwo;
}


}
