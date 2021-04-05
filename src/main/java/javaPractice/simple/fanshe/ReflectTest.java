package javaPractice.simple.fanshe;

import com.common.po.Gps;
import javaPractice.common.utils.ReflectUtils;

public class ReflectTest {
    public static void main(String[] args) {
        Gps gps =new Gps();
        ReflectUtils.getResultByReflect(gps);
    }
}
