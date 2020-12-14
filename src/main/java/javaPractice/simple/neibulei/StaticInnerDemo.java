package javaPractice.simple.neibulei;

/**
 * @功能：
 * @author liqiankun
 * @param 使用static使用内部类           
 * @throws
 * @日期 2019年6月22日
 * @时间 下午3:31:37
 */
public class StaticInnerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 访问内部类
		new StaticOuter.StaticInner().print();
	}
}

class StaticOuter {
	private static String hello = "helloWorld";
	static class StaticInner{
		public void print() {
			System.out.println(hello);
		}
	}
	
}
