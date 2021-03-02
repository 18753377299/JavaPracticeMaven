package javaPractice.LeetCode.suanfa.PrintOrder_1114;

public class ThreadMessageRunnable implements Runnable {
    private String message;

    public ThreadMessageRunnable(String message) {
        this.message = message;
    }

    public void run(){
        System.out.println(message);
    }
}
