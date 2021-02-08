package javaPractice.simple.thread_10.wait_notify;

public class BaoZiPu  extends Thread{
    BaoZi bz;

    public BaoZiPu(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    public void run(){
        int count = 0;

      synchronized (bz){
          while(true&&count<10){
             if(bz.isFlag() == true){
                 try {
                     /**包子铺有包子的时候是等待状态,
                      * wait()状态相当于return，线程不会往下执行了。
                      * */
                     bz.wait();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }
             if(count%2 ==0){
                 bz.setPier("菠菜");
                 bz.setXianer("猪肉大葱");
             }else{
                 bz.setPier("杂粮");
                 bz.setXianer("牛肉大葱");
             }
             count++;
             System.out.println("包子铺正在包"
                      +bz.getPier()+","+bz.getXianer()+"的包子,可以吃了");
             bz.setFlag(true);
             bz.notify();
          }
      }
    }
}
