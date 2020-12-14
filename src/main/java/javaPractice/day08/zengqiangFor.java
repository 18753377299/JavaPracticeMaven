package javaPractice.day08;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zengqiangFor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String,String>();
		map.put("1", "张三");
		map.put("2 ","李四");
		map.put("3", "wangwu");
		for(String key:map.keySet()){
			String value=map.get(key);
			System.out.println(key+"="+value);
		}
//		List<String> list=new ArrayList<String>();
		
		
	}
	public class A<T>{
		private T beanT;

		public T getBeanT() {
			return beanT;
		}

		public void setBeanT(T beanT) {
			this.beanT = beanT;
		}
		
	}

}
