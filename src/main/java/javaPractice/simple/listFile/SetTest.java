package javaPractice.simple.listFile;

import java.util.HashSet;
import java.util.Set;

//Set中addAll方法中不能够添加null，会报空指针异常
public class SetTest {
	 public static void main(String []args){
		 try {
			Set<String> setStr= new HashSet<String>();
			// Set中addAll方法中不能够添加null，会报空指针异常
			setStr.addAll(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
}
