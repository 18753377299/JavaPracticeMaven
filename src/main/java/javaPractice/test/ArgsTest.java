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
		else {
			System.out.println("=========error==========");
			/**
			 * system.exit（0）:正常退出，程序正常执行结束退出
			 * system.exit(1):是非正常退出，就是说无论程序正在执行与否，都退出。
			 * System.exit(status)不管status为何值都会退出程序
			*/
//			System.exit(1);
		}

		BigDecimal  bigDecimal = new BigDecimal("123456.895346232");
		System.out.println(bigDecimal.divide(new BigDecimal("10000"), 6,RoundingMode.HALF_UP));
	}
}
