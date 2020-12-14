package javaPractice.simple.bigdecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年7月23日 下午4:56:12
* @version 1.0
* @parameter
* @since
* @return  */
public class Test {

public static void main(String[] args) {
    try {
        String bbString = "12.01";
        BigDecimal bigDecimal = new BigDecimal(bbString.trim());

        System.out.println(bigDecimal);
        System.out.println(System.currentTimeMillis());
        // TODO Auto-generated method stub
        List<String> riskAssess = new ArrayList<String>();
        riskAssess.addAll(Arrays.asList("12.2", "32.93", "28.05", "9.76",
                "15.85", "1", "1", "1"));
        BigDecimal aa = new BigDecimal("81.0").divide(new BigDecimal(
                riskAssess.get(0)), 3, RoundingMode.HALF_UP);
        BigDecimal bbBigDecimal = aa.multiply(new BigDecimal("10"));
        System.out.println("==========================");
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
