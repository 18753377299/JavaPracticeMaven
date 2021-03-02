package javaPractice.LeetCode.suanfa.PrintOrder_1114;


import io.swagger.annotations.Api;

import java.util.concurrent.Semaphore;

@Api(value="通过信号量Semaphore")
public class FooSemaphore {

    private Semaphore firstSemaphore  = new Semaphore (0);
    private Semaphore secondSemaphore = new Semaphore(0);

    public FooSemaphore() {}

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        firstSemaphore.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstSemaphore.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        secondSemaphore.release();
    }

    public void third(Runnable printThird) throws InterruptedException {

        secondSemaphore.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
