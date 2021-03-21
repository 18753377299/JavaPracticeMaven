package javaPractice.lambda.FunctionInterface;

import io.swagger.annotations.Api;

import java.util.Arrays;
import java.util.List;

@Api(value="函数式接口")
public class FunctionInterface {
    public static void main(String[] args) {
        List<String> listOne = Arrays.asList("one","two","three");
        InterfaceOne one =()->{System.out.println("methodOne"); };
        listOne.forEach((item)->{
            System.out.println(item.getClass().getInterfaces()[0]+":"+item.toUpperCase());
        });
    }
}

@FunctionalInterface
interface  InterfaceOne{
    public void methodOne();
}
@FunctionalInterface
interface  InterfaceTwo{
    public void methodTwo();
}


