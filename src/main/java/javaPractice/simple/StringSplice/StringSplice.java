package javaPractice.simple.StringSplice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年11月25日 下午2:09:11
 * @version 1.0 
 * @parameter 
 * @since  字符串拼接
 * @return  */
public class StringSplice {

	public static void main(String[] args) {
		String  str = "2,5,7,9,11";
		List<String> strList = new ArrayList<String>(Arrays.asList(str));
		System.out.println("========list======"+strList);
		strList.add("17");
		String strNew = StringUtils.join(strList,",");
		System.out.println("========new======"+strNew);
		String   newStr = "2";
		/*如果只有一个字段，执行split 之后也会转换为数组。*/
		String [] newArray = newStr.split(",");
		System.out.println("=======array========="+newArray);
	}

}
