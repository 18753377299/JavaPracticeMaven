package javaPractice.simple.thread_10.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Demo06Comparator {
    public static void main(String []args){
        Person [] array = {
                new Person("张三",23),
                new Person("李四",19),
                new Person("王二",20),
        };

        Comparator<Person> com = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        };
        Arrays.sort(array,com);

        for (Person person : array) {
            System.out.println(person);
        }


        Person [] array2 = {
                new Person("张三2",23),
                new Person("李四2",19),
                new Person("王二2",20),
        };

        Arrays.sort(array2,(Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        for (Person person : array2) {
            System.out.println(person);
        }


    }
}
