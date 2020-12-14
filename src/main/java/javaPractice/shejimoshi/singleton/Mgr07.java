package javaPractice.shejimoshi.singleton;

/*
 * 比Mgr01好
 * 静态内部类
 * JVM保证单例
 * 加载外部类的时不会加载内部类，这样可以实现懒加载
*/

public class Mgr07{

	
	private static class  Mgr07Holder {
		private static Mgr07 instance = new Mgr07();
	}
	private Mgr07() {}
	
	private static Mgr07 getInstance() {
		return Mgr07Holder.instance;
	}
	
	public static void main(String [] args) {
		for(int i=0;i<100;i++) {
			//第一种写法： 可以使用lambok进行简化
			new Thread (new Runnable() {
				@Override
				public void run() {
					System.out.println(Mgr07.getInstance().hashCode());
				}
			}).start();
			//第二种写法：
			/*new Thread (()->{
				System.out.println(Mgr03.getInstance().hashCode());
			}).start();*/
			
		}
	}
}
