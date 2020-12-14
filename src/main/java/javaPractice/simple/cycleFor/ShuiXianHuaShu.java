package javaPractice.simple.cycleFor;

/**
 * @功能：1.查询出所有的“水仙花数”，水仙花数是一个三位数，三位数字的立方和等于该数本身
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月13日
 * @时间 下午4:55:20
 */
public class ShuiXianHuaShu {
	public static void main(String []args) {
		try {
			for(int i=100;i<1000;i++) {
				int sum =0,a,b,c;
				a  = i/100;
				b=i%100/10;
				c=i%10;
				sum = a*a*a+b*b*b+c*c*c;
				if(i==sum) {
					System.out.println("水仙花数是："+i);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
