package javaPractice.simple.neibulei;


/**
 * @功能：
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月22日
 * @时间 上午10:22:13
 */
public class InnerDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Outer().fun();
		// 外部访问内部类
		Outer outer = new Outer();
		Outer.Inner inner = outer.new Inner();
		inner.print();
	}

}
class Outer {
	private static String  info ="you are right";
	class Inner{
		public void print() {
			System.out.println(info);
		}
	}
	public void fun() {
		new Inner().print();
	}
	
	
}
