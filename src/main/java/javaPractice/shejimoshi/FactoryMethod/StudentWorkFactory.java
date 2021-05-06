package javaPractice.shejimoshi.FactoryMethod;

public class StudentWorkFactory implements  WorkFactory{
    public Work getWork(){
        return new StudentWork();
    }
}
