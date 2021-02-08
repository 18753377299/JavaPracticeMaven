package javaPractice.simple.thread_10.lambda;

public class Demo08InvokeCalc {
    public static void main(String []args){
        // 有参，参数类型可以省略
        invokeCalc(120,110,(int a,int b)->{
           return a+b;
        });

        //无参
        invokeCook(()->{
            System.out.println("吃饭啦");
        });
    }

    public static void invokeCalc(int a ,int b,Calculator calculator){
        int c = calculator.calc(a, b);
        System.out.println("result{}->"+c);
    }

    private static void invokeCook(Cook cook) {
        cook.makeFood();
    }


}
