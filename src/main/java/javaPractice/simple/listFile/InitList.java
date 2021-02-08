package javaPractice.simple.listFile;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/** https://blog.csdn.net/qq_24562495/article/details/84837239*/
//初始化list数据
public class InitList {

	public static void main(String[] args) {
		// 方式一：
		List<String> stringList = new LinkedList<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		// 方式二
		List<String> stringListTwo = new LinkedList<String>(){{
			add("a");
			add("b");
			add("c");
		}};
		// 方式三：
		List<String> stringListThree = Arrays.asList("a", "b", "c");
		// TODO Auto-generated method stub
		/*通过数组转换为list信息*/
		String [] strArray = {"1","2","3"};
		String [] strArray1 = new String [10];
		strArray1[0] ="aaa";
		String [] strArray2 = new String [] {"1","2","3"};
		// 方式四
//		List<String> list = Stream.of("a", "b", "c").collect(Collectors.toList());

		List<String> strList = new ArrayList<String>(Arrays.asList(strArray));
		strList = Arrays.asList(strArray);
		
		System.out.println(strList);
		
		/*判断list集合非空的方式*/
		if(CollectionUtils.isNotEmpty(strList)) {
			System.out.println("isNotEmpty");
		}
	}

}
