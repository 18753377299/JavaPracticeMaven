package javaPractice.simple.thread_10;

import io.swagger.annotations.Api;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * public void lock() :加同步锁
 * public void unlock() :释放同步
 */

@Api("lock锁")
public class ThreadLock {
    public static void main(String []args){
        ThreadLockRunnable threadLockRunnable =new ThreadLockRunnable();

        new Thread(threadLockRunnable,"窗口1").start();
        new Thread(threadLockRunnable,"窗口2").start();
        new Thread(threadLockRunnable,"窗口3").start();
    }
}
class ThreadLockRunnable implements Runnable{
    public int ticket = 100;
    Lock lock =new ReentrantLock();

    @Override
    public void run(){
       while (true){
           lock.lock();
           if(ticket>0){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               String name = Thread.currentThread().getName();
               System.out.println(name+",target:"+ticket--);
           }
           lock.unlock();
       }
    }
}
