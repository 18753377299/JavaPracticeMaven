package javaPractice.simple.thread_10;

import io.swagger.annotations.ApiOperation;

/**
 * @功能：使用runnable来实现多线程
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年7月4日
 * @时间 下午7:23:00
 */
public class OnlyRunner implements Runnable{

	@ApiOperation(value="使用runnable来实现单线程")
	public static void main(String [] args) {
		OnlyRunner onlyRunner  = new OnlyRunner();
		Thread thread = new Thread(onlyRunner);
		thread.start();
		
		thread.setPriority(Thread.NORM_PRIORITY); // 优先级
		Thread.currentThread().yield(); // 线程的礼让
	}

	@Override
	public void run() {
	   for(int i =0;i<10;i++) {
		   System.out.println("hello:"+i);
	   }
	}
}
