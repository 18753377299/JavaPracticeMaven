package javaPractice.LeetCode.mianshi.topic_1_1;

import java.util.HashSet;
import java.util.Set;


/*判定字符是否唯一:
	实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
	示例 1：
	输入: s = "leetcode"
	输出: false 
	示例 2：
	输入: s = "abc"
	输出: true
	限制：
	0 <= len(s) <= 100
	如果你不使用额外的数据结构，会很加分。*/

public class UniqueChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String simpleStr = "abcccc";
			boolean flag = isUnique0(simpleStr);
			System.out.println("============="+flag);
	}
	
   /*第一种： 将字符串转换为数组进行，然后插入到set中，如果set的长度和数组长度一致，说明全都不同*/
	public static boolean isUnique(String astr) {
		char[] chars = astr.toCharArray();
        Set<String> set = new HashSet<String>();
        for (int i=0;i<chars.length;i++){
            set.add(String.valueOf(chars[i]));
        }
        if(astr.length()==set.size()){
            return true;
        }
        return false;
    }
    /*第二种:  */
	public static boolean isUnique2(String astr) {
		Set set =new HashSet();
		for(int i =0;i<astr.length();i++){
			set.add(astr.charAt(i));
		}
		return set.size()==astr.length();
	}
	
	/*第三种： 将各个字符添加到set中，如果已存在，则返回false*/
	public boolean isUnique3(String astr) { 
		Set set = new HashSet(); 
		// add方法： 如果指定的元素不存在就把他添加到集合中去
		for (int i = 0; i <astr.length() ; i++) { 
			if( !set.add(astr.charAt(i))){
				return false;
			}
		}
		return true;
	}
	/*第四种： 思路:
	由于ASCII码字符个数为128个，而且题目说了如果你不使用额外的数据结构，会很加分。
	因此可以使用两个64位的long变量来存储是否出现某个字符，二进制位1表示出现过， 0表示未出现过。具体代码如下：*/
	public boolean isUnique4(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0) {
                    return false;
                }
                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }
                low64 |= bitIndex;
            }

        }

        return true;
    }
	/*创建数组存放每个字母出现的次数。顺序扫描字符串，
	对应扫描到的字母数组元素+1。最后如果数组元素有大于等于2的数则返回false，否则返回true*/
	public static boolean isUnique0(String astr) {
        int[] nums = new int[100];
        //a的ascii码为97，对应数组0号元素
        for(int i = 0;i<astr.length();i++){
            char item = astr.charAt(i);
            int result = item;
            result = result-97;
            nums[result]++;
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i]>=2){
                return false;
            }
        }
        return true;
    }
	/*位置不一样就是存在多个字符*/
	public boolean isUnique5(String astr) {
	    //方法1：用map/set存放
	    //方法2：indexof  lastindexof
	    //方法3：arr[ch - 'a']!=0
	    for (char ch: astr.toCharArray()){
	        if (astr.indexOf(ch) != astr.lastIndexOf(ch)) {
	        	return false;
	        }
	    }
	    return true;
	}


	
}
