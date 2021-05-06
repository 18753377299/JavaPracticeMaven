package javaPractice.shejimoshi.FactoryMethod;

import io.swagger.annotations.Api;

@Api(value = "工厂方法实现")
public class FactoryMethodMain {
    public static void main(String[] args) {

        WorkFactory workFactory = new TeacherWorkFactory();
        workFactory.getWork().doWork();

        WorkFactory workFactoryTwo =new StudentWorkFactory();
        workFactoryTwo.getWork().doWork();

    }

}

