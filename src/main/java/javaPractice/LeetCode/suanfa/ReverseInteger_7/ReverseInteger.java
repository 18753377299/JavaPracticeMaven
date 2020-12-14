package javaPractice.LeetCode.suanfa.ReverseInteger_7;

/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
示例 1:
输入: 123
输出: 321
 示例 2:
输入: -123
输出: -321
示例 3:
输入: 120
输出: 21
注意:
假设我们的环境只能存储得下 32 位的有符号整数，
则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。*/

public class ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//         int num = -2147483648;
//         int result = reverseInt(num);
//         System.out.println(result);
		 int num = 456756340;
		 System.out.println(num%10);
         int resultTwo = reverseIntTwo(num);
         System.out.println(resultTwo);
	}
	/*因为使用的是int类型，这个时候我们需要考虑溢出问题: 当大于最大值和小于最小值的时候会发生溢出现象，
	 * 每一次计算新值的时候需要判断是否溢出
	 * 7为最大值的个位数；8为最小值的个位数
	 * */
	public static int reverseIntTwo(int num){
		int target =0;
		while(num!=0){
			int begin = num%10;
			if(target>Integer.MAX_VALUE/10||(target==Integer.MAX_VALUE/10&&begin>7)){
				return 0;
			}else if(target<Integer.MIN_VALUE/10||(target==Integer.MIN_VALUE/10&&begin<-8)){
				return 0;
			}
			target = target*10+begin;
			num = num/10;
		}
		return target;
	}
	/*方法比较烂*/
	public static int  reverseInt(int num){
		double result;
		boolean flag= false;
		if(num<0){
			flag = true;	
		}
		if(num==0||(num<0&&-num<0)){
			return 0;
		}
		int num_b =Math.abs(num);
//		int num_b = Math.abs(num);
		int num_c = removerZero(num_b);
		String str = reverseStr(num_c);
		result = Double.parseDouble(str);
		if(result>Integer.MAX_VALUE){
			result = 0;
		}
		if(flag){
			result *=-1;
		}
		return (int)result;
	}
	public static String reverseStr(int num){
		StringBuffer buffer=new StringBuffer("");
		String among = String.valueOf(num);
		for (int i=0;i<among.length();i++){
			buffer.append(among.charAt(among.length()-1-i));
		}
		return buffer.toString();
	}
	public static int removerZero(int num){
		while(num%10 ==0){
			num =num/10;
		}
		return num;
	}

}
