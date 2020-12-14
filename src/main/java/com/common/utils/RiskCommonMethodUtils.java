package com.common.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年8月14日 下午3:52:15
* @version 1.0
* @parameter
* @since
* @return  */
public class RiskCommonMethodUtils {


// 避免在方法内多次新建数组而设立的两个基础数组
private static final Object[] EMPTY_ARRAY = new Object[0];

/**
 * @功能：为大对象的某特定字段赋值
 * @author
 * @param object  大对象
 * @param fieldName  字段名称（以大写字母开头）
 * @param value
 *            要设置的值
 * @throws @日期
 *             2017-10-23
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public static void setValueforSpecificField(Object object, String fieldName, Object value) throws Exception {
    // if(object == null) {
    // return;
    // }
    try {
        if (object != null) {
            Object[] SINGLE_ELEM_ARRAY = new Object[1];
            Class objectClass = object.getClass();
            // 获取所有getter方法
            List<Method> getterMethods = new ArrayList<Method>();
            getterMethods = getGetter(objectClass);
            // 获取方法实例
            Class paramType = null;
            String currentFieldName;
            // 获取所有字表
            for (Method method : getterMethods) {
                currentFieldName = method.getName().substring(3);
                // 一对多子表处理
                if (method.getReturnType() == List.class) {
                    List<Object> subObjects = (List<Object>) method.invoke(object, EMPTY_ARRAY);
                    if (subObjects == null) {
                        continue;
                    }
                    // 循环遍历子对象
                    for (Object obj : subObjects) {
                        setValueforSpecificField(obj, fieldName, value);
                    }
                    // 联合主键处理
                } else if ("Id".equals(currentFieldName)) {
                    Object objectID = method.invoke(object, EMPTY_ARRAY);
                    setValueforSpecificField(objectID, fieldName, value);
                } else if (currentFieldName.equals(fieldName)) {
                    // 找到了要赋值的属性，执行赋值（1、加if是为了不重复获取，2、在这里获取是避免NoSuchMethodException）
                    if (paramType == null) {
                        // 首先得到getter方法（用于获取返回值的类型）
                        Method getterMethod = objectClass.getMethod("get" + fieldName);
                        // 获取其返回值的类型
                        paramType = getterMethod.getReturnType();
                    }
                    // 得到其setter方法
                    Method setterMethod = objectClass.getMethod("set" + fieldName, paramType);

                    SINGLE_ELEM_ARRAY[0] = value;
                    setterMethod.invoke(object, SINGLE_ELEM_ARRAY);
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("某特定字段赋值异常:" + e);
    }
}

/**
 * @功能：获取类及其父类的所有get方法
 * @author 马军亮
 * @param cl
 *            待获取的类
 * @return 所有get方法
 * @throws @日期
 *             2017-10-23
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
private static List<Method> getGetter(Class cl) {
    List list = new ArrayList();
    try {
        Method[] methods = cl.getDeclaredMethods();
        int lgn = methods.length;
        for (int i = 0; i < lgn; ++i) {
            Method method = methods[i];
            String methodName = method.getName();
            // 以set或is开头的方法
            if (methodName.startsWith("get") || methodName.startsWith("is")) {
                list.add(method);
            }
        }
        cl = cl.getSuperclass();
        // 递归获取父类的get方法
        if (cl != Object.class) {
            list.addAll(getGetter(cl));
        }
    } catch (SecurityException e) {
        e.printStackTrace();
        throw new RuntimeException("获取类及其父类的所有get方法异常:" + e);
    }
    return list;
}


}
