package javaPractice.shejimoshi.singleton;

/*懒汉式：
 * 什么时候用到什么时候进行初始化.
 * 虽然达到了初始化的目的，但却带来了线程不安全的问题(可能不是同一个对象,同一个类的把不同对象hashcode是不同的)
 * 可以通过  synchronized解决，但是也带来了效率下降，为了提升效率使用内部双重锁
 * synchronized : 锁定当前对象
*/

public class Mgr05{
//	volatile: 
	private static  volatile Mgr05 instance ;  // jit
	
	private Mgr05() {}
	
	private static Mgr05 getInstance() {
		if(null==instance) {
//			双重检查
			synchronized (Mgr05.class) {
				if(null==instance) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					instance = new Mgr05();
				}
			}
		}
		return instance;
	}
	
	public static void main(String [] args) {
		for(int i=0;i<100;i++) {
			//第一种写法： 可以使用lambok进行简化
			new Thread (new Runnable() {
				@Override
				public void run() {
					System.out.println(Mgr05.getInstance().hashCode());
				}
			}).start();
			//第二种写法：
			/*new Thread (()->{
				System.out.println(Mgr03.getInstance().hashCode());
			}).start();*/
			
		}
	}
}
