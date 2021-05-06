package javaPractice.lambda;

import java.util.Optional;

/*对Java8的语法进行测试*/
/*java8 orElse，orElseGet，orElseThrow的使用:
* from:   https://blog.csdn.net/enthan809882/article/details/103997326
* */
public class JavaEight {

    public static void main(String []args){

       /* 这3个都是用来处理null的情况：
        orElse 用的是括号内的对象
        orElseGet 用的是Supplier接口返回的对象。 supplier接口就一个get方法。
        无入参，出参要和Optional的对象同类型。
        orElseThrow 用的是Supplier接口返回的对象，这个对象必须要实现Throwable。
         supplier接口就一个get方法。 无入参，出参要实现Throwable.
     */
        //orElse 有，就用自身值。  为null，就用orElse后面的值。
        //有正品用正品，没正品用替代品
        System.out.println(Optional.ofNullable("正品").orElse("替代品"));  // orElse
        System.out.println(Optional.ofNullable(null).orElse("替代品"));

        /*orElse和orElseGet：区别是orElseGet可以传入一个接口，来定制逻辑*/
        System.out.println(Optional.ofNullable("宝马").orElseGet(()->"走路"));  // 有宝马就不用走路
        System.out.println(Optional.ofNullable(null).orElseGet(()->"走路"));

        /*这两个函数的区别：当user值不为null时，test()方法，
        而orElseGet函数并不会执行test()方法，大家可自行测试。  begin*/
        System.out.println(Optional.ofNullable("正品").orElse(test()));  // orElse
        System.out.println(Optional.ofNullable(null).orElse(test()));


        System.out.println(Optional.ofNullable("宝马").orElseGet(()->test()));
        System.out.println(Optional.ofNullable(null).orElseGet(()->test()));

          /*这两个函数的区别：当user值不为null时，test()方法，
        而orElseGet函数并不会执行test()方法，大家可自行测试。  end*/


        /*orElseThrow代码*/
            // 有钱就没异常
        try {
            System.out.println(Optional.ofNullable("钱").orElseThrow(()->new Exception()));  // 有钱不会抛异常
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // 没钱就会抛异常
        try {
            System.out.println(Optional.ofNullable(null).orElseThrow(()->new Exception()));  // 没钱抛异常
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

//        Optional.ofNullable("钱").filter().map();

    }


    public static String test(){
        System.out.println("111");
        return   "success";
    }

}




