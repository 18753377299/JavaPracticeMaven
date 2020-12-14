package javaPractice.shejimoshi.singleton;

/*懒汉式：
 * 什么时候用到什么时候进行初始化.
 * 虽然达到了初始化的目的，但却带来了线程不安全的问题(可能不是同一个对象,同一个类的把不同对象hashcode是不同的)
*/

public class Mgr03{

	private static Mgr03 instance ;
	
	private Mgr03() {}
	
	private static Mgr03 getInstance() {
		if(null==instance) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			instance = new Mgr03();
		}
		return instance;
	}
	
	public static void main(String [] args) {
		for(int i=0;i<100;i++) {
			//第一种写法： 可以使用lambok进行简化
			new Thread (new Runnable() {
				@Override
				public void run() {
					System.out.println(Mgr03.getInstance().hashCode());
				}
			}).start();
			//第二种写法：
			/*new Thread (()->{
				System.out.println(Mgr03.getInstance().hashCode());
			}).start();*/
			
		}
	}
}
