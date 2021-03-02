package javaPractice.simple.thread_10.lambda;

import io.swagger.annotations.Api;

import java.util.Comparator;
import java.util.TreeSet;

@Api(value="比较大小的lambda表达式")
public class ComparatorLambda {
    public static void main(String[] args) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        };

        TreeSet<String> treeSet = new TreeSet<>(comparator);

        /*方式二*/
        Comparator<String> comparator1 = (o1,o2)->o1.length()-o2.length();
        TreeSet<String> treeSet1 = new TreeSet<>(comparator1);
        /*方式三*/
        TreeSet<String> treeSet2 = new TreeSet<>((o1,o2)->o1.length()-o2.length());

    }
}
