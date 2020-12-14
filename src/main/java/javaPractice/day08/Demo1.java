package javaPractice.day08;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Demo1 {
	
	//构造类的常用方法
	public static void fun1() throws Exception{
		 Class clazz=Class.forName("day08.User");
		 Constructor constructor=clazz.getConstructor(String.class,String.class);
		 User user=(User)constructor.newInstance("lisi","123");
		 
		 Method method=clazz.getMethod("toString");
		 String result=(String)method.invoke(user);
		 System.out.println("result="+result);
		 System.out.println(user);
	}
	public static void main(String[]args){
		try {
			fun1();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}		
	}
}
