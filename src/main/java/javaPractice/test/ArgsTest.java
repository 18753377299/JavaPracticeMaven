package javaPractice.test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @功能：
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年7月3日
 * @时间 上午10:15:08
 */
public class ArgsTest {
	public static void main(String []args) {
		if(args.length>0) {
			System.out.println("===================");
			for(String str:args) {
				System.out.println(str);
			}
			System.out.println("============="+args[2]);
		}
//		else {
//			System.out.println("=========error==========");
//			System.exit(1);
//		}
		BigDecimal  bigDecimal = new BigDecimal("123456.895346232");
		
		System.out.println(bigDecimal.divide(new BigDecimal("10000"), 6,RoundingMode.HALF_UP));
		
	}
}
