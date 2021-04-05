package javaPractice.common.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ReflectUtils {
    public static Map<String, Object> getResultByReflect(Object obj){
        Map<String, Object> map = new HashMap<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("serialVersionUID")
                    || field.getType().getName().equals("java.util.List")) {
                continue;
            }
            String fieldName = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            try {
                Method method = obj.getClass().getMethod("get" + fieldName, new Class[]{});
                Object invokeResult = method.invoke(obj);
                map.put(field.getName(), invokeResult);
            } catch (Exception e) {
//                LOGGER.info("构建word插值数据异常" + e.getMessage(), e);
                e.printStackTrace();
                throw new RuntimeException("构建word插值数据异常");
            }
        }
        return map;
    }
}
