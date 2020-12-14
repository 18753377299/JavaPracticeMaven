package javaPractice.simple.abstractclassInterface;
/**
 * @功能：
 * @author liqiankun
 * *@param 抽象类和抽象方法：
 * https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=2651934881&idx=1&sn=0e810c0fb036b72ad02ac08f731dbeda&scene=19#wechat_redirect
 * @throws
 * @日期 2019年7月3日
 * @时间 上午10:50:08
 * 抽象类：
 * 1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
　　2）抽象类不能用来创建对象；
　　3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类。
接口：
三.抽象类和接口的区别
 */
public class B  extends A{
    public static void main(String [] args){
        B  b =new  B();
        b.print();
    }
    public void print(){
        System.out.println("=============>>");
    }

}

/*抽象类：抽象类中方法只需要声明，不需要具体的方法内容 */
/*如果一个类含有抽象方法，则称这个类为抽象类，抽象类必须在类前用abstract关键字修饰。*/
abstract class A {
     private String name;
     abstract void print();
}
