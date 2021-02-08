package javaPractice.simple.thread_10.wait_notify;

public class ChiHuo  extends Thread {
    BaoZi bz;

    public ChiHuo(String name, BaoZi bz) {
        super(name);
        this.bz = bz;
    }

    public void run(){
         while(true){
             synchronized  (bz){
                  if(bz.isFlag()== false){
                      try {
                          /**没有包子的时候是等待*/
                          bz.wait();
                      } catch (InterruptedException e) {
                          e.printStackTrace();
                      }
                  }
                  System.out.println("吃货正在吃： "
                         +bz.getPier()+","+bz.getXianer()+"的包子");
                  bz.setFlag(false);
                  bz.notify();
             }
         }
    }

}
