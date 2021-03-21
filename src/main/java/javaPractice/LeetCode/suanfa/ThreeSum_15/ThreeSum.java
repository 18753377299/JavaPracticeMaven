package javaPractice.LeetCode.suanfa.ThreeSum_15;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**15. 三数之和:
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
使得a + b + c = 0请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。
示例：
给定数组 nums = [-1, 0, 1, 2, -1, -4]，
满足要求的三元组集合为：
[
 [-1, 0, 1],
 [-1, -1, 2]
]
 示例 2：
 输入：nums = []
 输出：[]
 示例 3：
 输入：nums = [0]
 输出：[]
 提示：
 0 <= nums.length <= 3000
 -105 <= nums[i] <= 105
 */
@Api(value="三数之和")
public class ThreeSum {

	public static void main(String[] args) {

		int [] nums = {-1, 0, 1, 2, -1, -4};
//		int [] nums = {};
		List<List<Integer>> result= calculateThreeSum(nums);
		result.stream().forEach(item->{
			System.out.println(item.toString());
		});
	}

	@ApiOperation(value="计算三个数的和,不能有重复数组",
			notes="使用双指针进行比较，其中的一个值可以作为结果值，如果指针左侧的数据")
	public static List<List<Integer>> calculateThreeSum(int [] nums){
		List<List<Integer>> result = new ArrayList<List<Integer>>() ;
		if(null==nums || nums.length==0){
//            throw new RuntimeException("数组不能为空！");
			return result;
		}
		/**进行数组排序:为了进行指针操作的时候，不出现重复数据*/
		Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			if(i>0 && nums[i] ==nums[i-1]){
				continue;
			}
			int target = -nums[i];
			int m = nums.length-1;
			for(int k=i+1;k<nums.length;++k){
				if(k>i+1 && nums[k]== nums[k-1]){
					continue;
				}
                while(k<m && nums[k]+nums[m]>target){
                	--m;
				}
                if(k==m){
                	break;
				}
			    if(nums[k]+nums[m]== target){
			       List<Integer>  amongList = new ArrayList<>();
					amongList.addAll(Arrays.asList(Integer.valueOf(nums[i]),
							Integer.valueOf(nums[k]),Integer.valueOf(nums[m])));
				   result.add(amongList);
			    }
			}
		}
		return result;
	}

}
