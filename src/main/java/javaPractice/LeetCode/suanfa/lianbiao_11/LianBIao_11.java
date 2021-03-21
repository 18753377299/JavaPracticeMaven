package javaPractice.LeetCode.suanfa.lianbiao_11;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。
    输入：[1,8,6,2,5,4,8,3,7]
    输出：49
    解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
    示例 2：
    输入：height = [1,1]
    输出：1
    示例 3：
    输入：height = [4,3,2,1,4]
    输出：16
    示例 4：
    输入：height = [1,2,1]
    输出：2
    提示：
    n = height.length
    2 <= n <= 3 * 104
    0 <= height[i] <= 3 * 104
    */
@Api(value="双向链表")
public class LianBIao_11 {
    @ApiOperation(value="从两边进行循环遍历")
    public static void main(String[] args) {
        // 13
       int [] req = {1,3,5,7,8,3,5,2,6,3,7,9,2};
       int result = getMaxWater(req);
        System.out.println("{}====>"+result);
    }
    @ApiOperation(value="进行双向遍历，如果左侧索引下的值较小，" +
            "那么左侧索引加1，右侧索引对应值较小，右侧索引减1")
    public static int getMaxWater(int [] array){
        int m = array.length-1;
        int n =0;
        int result= 0;
        while(n<m){
            result = Math.max(result,Math.min(array[n],array[m])*(m-n));
            if(array[n]<=array[m]){
                ++n;
            }else {
                --m;
            }
        }
        return result;
    }
}
