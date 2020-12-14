package javaPractice.LeetCode.mianshi.topic_1_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/*判定是否互为字符重排:
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
示例 1：
输入: s1 = "abc", s2 = "bca"
输出: true 
示例 2：
输入: s1 = "abc", s2 = "bad"
输出: false
说明：
0 <= len(s1) <= 100
0 <= len(s2) <= 100*/

/*分析：如果可以进行字符重排，说明两个字符串中相同字符的数量是一样的，这样无论进行怎样的排列组合都能将两者排成一样的。*/

public class RangeStr {

	public static void main(String[] args) {
		String str1="abcc";
		String str2 ="cbad";
		System.out.println(checkTrue(str1,str2));
//		int [] indexs = new int[128];
//		indexs['q']=1;
//		for(int i=0;i<indexs.length;i++){
//			System.out.println(indexs[i]);
//		}
	}
	/*public boolean  CheckPermutation(string s1, string s2) {
	        unordered_map<char,int> hash;
	        if(s1.size()!=s2.size())
	        return false;
	        for(auto str1:s1)
	            hash[str1]++;
	        for(auto str2:s2)
	        {
	            if(hash[str2]==0)
	            return false;
	            hash[str2]--;
	        }
	        return true;
	    }*/
	
	/*第二种： 直接将字符串进行排序，然后判断字符串是否相等*/
	 public boolean CheckPermutation(String s1, String s2) {
	        char[] c1=s1.toCharArray();
	        Arrays.sort(c1);
	        char[] c2=s2.toCharArray();
	        Arrays.sort(c2);
	        return new String(c1).equals(new String(c2));
	}
	 
	/*第一种*/
	public static boolean checkTrue(String str1,String str2){
		if(str1.length()!=str2.length()){
			return false;
		}
		Map<Character,Integer> mapOne = formMapData(str1);
		Map<Character,Integer> mapTwo = formMapData(str2);
		if(mapOne.equals(mapTwo)){
			return true;
		}
		return false;
	}
	public static Map<Character,Integer> formMapData(String str){
		Map<Character,Integer> map = new HashMap<Character, Integer>();
		for(int i=0;i<str.length();i++){
			if(!map.containsKey(str.charAt(i))){
				Integer num = 1;
				map.put(str.charAt(i),num);
			}
			Integer numTotal =  map.get(str.charAt(i))+1;
			map.put(str.charAt(i), numTotal);
		}
		return map;
	}
	
	

}
