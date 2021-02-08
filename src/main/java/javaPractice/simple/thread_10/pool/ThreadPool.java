package javaPractice.simple.thread_10.pool;

import io.swagger.annotations.Api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Api(value="线程池")
public class ThreadPool {
    public static void main(String []args){
        /**创建线程池*/
        ExecutorService executorService =
                Executors.newFixedThreadPool(2);
        MyRunnable myRunnable = new MyRunnable();
        // 从线程池中获取线程对象,然后调用MyRunnable中的run()
        executorService.submit(myRunnable);

        executorService.submit(myRunnable);
        executorService.submit(myRunnable);
        // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
        // 将使用完的线程又归还到了线程池中
        // 关闭线程池
        //executorService.shutdown();

    }
}
