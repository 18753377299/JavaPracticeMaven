package javaPractice.shejimoshi.FactoryMethod;

public class TeacherWorkFactory implements  WorkFactory{
    public Work getWork(){
        return new TeacherWork();
    }
}
