package javaPractice.shejimoshi.singleton;

/*
 * 不仅可以解决线程同步，还可以防止反序列化（因为枚举没有构造方法）
*/

public enum Mgr08{

	instance;
	
	public static void main(String [] args) {
		for(int i=0;i<100;i++) {
			//第一种写法： 可以使用lambok进行简化
			new Thread (new Runnable() {
				@Override
				public void run() {
					System.out.println(Mgr08.instance.hashCode());
				}
			}).start();
			//第二种写法：
			/*new Thread (()->{
				System.out.println(Mgr03.getInstance().hashCode());
			}).start();*/
			
		}
	}
}
