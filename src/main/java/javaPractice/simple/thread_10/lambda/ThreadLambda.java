package javaPractice.simple.thread_10.lambda;

public class ThreadLambda {
    public static void main(String []args){

        // 内部类
        Runnable task =new Runnable() {
            @Override
            public void run() {
                System.out.println("这是一个内部类！");
            }
        };
        new Thread(task).start();

        //启动线程
        new Thread(()-> System.out.println("这是一个内部类2！")).start();



    }

}
