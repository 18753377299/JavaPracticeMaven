package javaPractice.LeetCode.suanfa.PrintOrder_1114;

import io.swagger.annotations.Api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**1114. 按序打印
        我们提供了一个类：
public class Foo {
    public void first() { print("first"); }
    public void second() { print("second"); }
    public void third() { print("third"); }
}
    三个不同的线程 A、B、C 将会共用一个 Foo 实例。
        一个将会调用 first() 方法
        一个将会调用 second() 方法
        还有一个将会调用 third() 方法
        请设计修改程序，以确保 second() 方法在 first() 方法之后被执行，third() 方法在 second() 方法之后被执行。

 示例 1:
        输入: [1,2,3]
        输出: "firstsecondthird"
        解释:
        有三个线程会被异步启动。
        输入 [1,2,3] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 second() 方法，线程 C 将会调用 third() 方法。
        正确的输出是 "firstsecondthird"。
        示例 2:
        输入: [1,3,2]
        输出: "firstsecondthird"
        解释:
        输入 [1,3,2] 表示线程 A 将会调用 first() 方法，线程 B 将会调用 third() 方法，线程 C 将会调用 second() 方法。
        正确的输出是 "firstsecondthird"。
        提示：
        尽管输入中的数字似乎暗示了顺序，但是我们并不保证线程在操作系统中的调度顺序。
        你看到的输入格式主要是为了确保测试的全面性。
*/
@Api("问题待确认？？？？,在ThreadFooRunnable写了两个构造函数" +
        "，先调两个个参数的，然后调用一个参数的，不能成功，重新写一个runnable就可以了")
public class ThreadPrintOrderTwo {
    public static void main(String []args){
        Foo foo = new Foo();
//        FooSemaphore foo =new FooSemaphore();
//        FooChild fooChild = new FooChild();
        /**线程池*/
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(new ThreadFooFirstRunnable("first",foo));
        executorService.submit(new ThreadFooSecondRunnable("second",foo));
        executorService.submit(new ThreadFooThirdRunnable("third",foo));

    }
}
