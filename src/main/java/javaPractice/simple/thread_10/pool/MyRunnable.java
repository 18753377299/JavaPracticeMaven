package javaPractice.simple.thread_10.pool;

public class MyRunnable implements  Runnable {

    public void run(){
        System.out.println("begin");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name:"
                + Thread.currentThread().getName()+",end");
    }
    /*public void run (){
        ()-> System.out.println("begin")
    }*/

}
