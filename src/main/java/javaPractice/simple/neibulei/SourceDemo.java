package javaPractice.simple.neibulei;

/**
 * @功能：不使用内部类，完成了和内部类的同样的功能
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月22日
 * @时间 下午4:01:32
 */
public class SourceDemo {
	public static void main(String []args) {
		
		new SourceOuter().fun();
	}
}
class SourceOuter{
	private static String  hello ="helloWorld";
	
	public static String getHello() {
		return hello;
	}

	public void fun() {
		new SourceInner().print();
	}
}

class SourceInner{
	SourceOuter sourceOuter =null;
	
	public SourceInner() {
		sourceOuter =new SourceOuter();
	}
	
	public void print() {
		System.out.println(sourceOuter.getHello());
	}
}
