package javaPractice.simple.listFile;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//初始化list数据
public class InitList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*通过数组转换为list信息*/
		String [] strArray = {"1","2","3"};
		String [] strArray1 = new String [10];
		strArray1[0] ="aaa";
		String [] strArray2 = new String [] {"1","2","3"};

		List<String> strList = new ArrayList<String>();
		strList = Arrays.asList(strArray);
		
		System.out.println(strList);
		
		/*判断list集合非空的方式*/
		if(CollectionUtils.isNotEmpty(strList)) {
			System.out.println("isNotEmpty");
		}
	}

}
