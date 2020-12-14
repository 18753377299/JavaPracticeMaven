package javaPractice.LeetCode.suanfa.TwoSum_1;


/* 韩信点兵，不足百人，三人一行多一人，七人一行少一人，五人一行正好，问有多少人，请设计方法，来计算出结果*/

public class CountPerson {
	public static void main(String []args){
		
		for (int i=1;i<100;i++){
			if(i%3==1&&i%7==6&&i%5==0){
				System.out.println("人数为:"+i);
			}
		}
	}
}
