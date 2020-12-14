package javaPractice.simple.array;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReplaceArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("---------------------------------------------->begin");
			/*连续进行两次replace替换，结果result的结果等于最后一次的替换结果
			 * 原因： String是不可修改的，使用replace 相当于创建了一个新的字符串，
			 *        所以需要对字符串重新定义，否则返回的还是原字符串。
			 * */
			String aa="abcd";
			aa.replace("a","f");
			System.out.println("输出结果是"+aa);

			String aaB="abcd";
			String replaceStr= aaB.replace("a", "f");
			System.out.println("输出结果是"+replaceStr);

			System.out.println("---------------------------------------------->end");
			String [] sorArray = {"001","008","009"};
			String sorArrayStr="";
			String newArray = "001,008,009";
			String result= "";
			sorArrayStr = StringUtils.join(sorArray,",");
			List<String> newList =new ArrayList<String>(Arrays.asList(sorArray));
			if(newList.contains("008")){
				/*这里是定义之后，第一次执行之后没有被使用到，所以用到的只是后一个result，
				所以相当于第一次执行replace没有生效；
				http://blog.sina.com.cn/s/blog_45eac6860100l05m.html
				*/
				result = newArray.replace("008", "006");
				result = newArray.replace("009", "007");

				// 这一次替换不改变值，需要重新定义一个新的字符串
				sorArrayStr.replaceAll("008", "006");

				newList.remove("008");
				newList.add("006");
			}
			System.out.println(result);
			System.out.println(sorArrayStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
