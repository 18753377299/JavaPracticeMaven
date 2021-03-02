package javaPractice.LeetCode.suanfa.PrintOrder_1114;

public class ThreadFooSecondRunnable implements Runnable {

    private String message;
    private Foo foo;

    private FooSemaphore fooSemaphore;

//    public ThreadFooRunnable(String message) {
//        this.message = message;
//    }

    public ThreadFooSecondRunnable(String message, Foo foo) {
        this.message = message;
        this.foo = foo;
//        System.out.println(message);
    }

    public ThreadFooSecondRunnable(String message, FooSemaphore fooSemaphore) {
        this.message = message;
        this.fooSemaphore = fooSemaphore;
    }

    public void run(){
//        firstMethod();
        secondMethod();
//        thirdMethod();

//        firstSemMethod();
//        secondSemMethod();
//        thirdSemMethod();
    }

    public void firstMethod(){
        try {
            foo.first(new ThreadMessageRunnable(message));
//            System.out.println(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void secondMethod(){
        try {
            foo.second(new ThreadMessageRunnable(message));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void thirdMethod(){
        try {
            foo.third(new ThreadMessageRunnable(message));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void firstSemMethod(){
        try {
            fooSemaphore.first(new ThreadMessageRunnable(message));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void secondSemMethod(){
        try {
            fooSemaphore.second(new ThreadMessageRunnable(message));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void thirdSemMethod(){
        try {
            fooSemaphore.third(new ThreadMessageRunnable(message));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
