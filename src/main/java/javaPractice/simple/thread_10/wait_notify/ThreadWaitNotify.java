package javaPractice.simple.thread_10.wait_notify;

import io.swagger.annotations.Api;

@Api(value="等待唤醒机制,需要多个线程完成一件任务")
public class ThreadWaitNotify {
    public static void main(String []args){
        BaoZi baoZi =new BaoZi();
        BaoZiPu baoZiPu =new BaoZiPu("包子铺",baoZi);
        ChiHuo chiHuo =new ChiHuo("吃货",baoZi);
        baoZiPu.start();
        chiHuo.start();
    }
}
