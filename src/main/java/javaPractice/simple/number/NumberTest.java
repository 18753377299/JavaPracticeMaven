package javaPractice.simple.number;

import com.common.utils.NumberUtils;

public class NumberTest {
    public static void main(String []args) {
        /*获取自增数据，输出结果为001*/
        String result = NumberUtils.getIncreaseNumber(1);
        System.out.println(result);
    }
}
