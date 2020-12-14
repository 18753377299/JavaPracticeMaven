package javaPractice.simple.thread_10;

/**
 * @功能：
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年7月4日
 * @时间 下午7:33:25
 */

public class ShareThread {

	public static void main(String[] args) {
		ShareMyThread  smt= new ShareMyThread();
		
		new Thread(smt).start();
		new Thread(smt).start();
		new Thread(smt).start();
	}

}
class ShareMyThread implements Runnable{
	private int target =6;

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			/*同步代码块，解决代码同步的问题*/
			synchronized (this) {
				if(target>0) {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("target:"+target--);
				}
			}
			
		}
		
	}
	
}
