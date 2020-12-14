package javaPractice.day08;

public class bianTai {
	public static void main(String []args){
		Integer i1=100;
		Integer i2=100;
		boolean b1=i1==i2;
		System.out.println("b1="+b1);
		//因为200 不在-128~127之间，需要重新创建对象，导致地址不同。
		Integer i3=200;
		Integer i4=200;
		boolean b2=i3==i4;
		System.out.println("b2="+b2);
	}
}
