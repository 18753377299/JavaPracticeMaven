package javaPractice.LeetCode.suanfa.TwoSum_1;

/*2. 两数相加
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807*/
public class AddTwoNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sum(243,564));
	}
	public static int sum (int num1,int num2) {
		return calculatePalindrome(num1)+calculatePalindrome(num2);
	}
	/*计算出该数的回文数，然后相加，输出*/
	public static int calculatePalindrome(int num) {
		int result = 0;
		while(num%10>0) {
			result =result*10 + (num%10);
			num = num/10;
		}
		return result;
	}
}
