package javaPractice.simple.trimTest;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年11月25日 上午9:32:13
 * @version 1.0 
 * @parameter 
 * @since  
 * 		str.trim(); //去掉首尾空格
		str.replace(" ",""); //去除所有空格，包括首尾、中间
		str.replaceAll(" ", ""); //去掉所有空格，包括首尾、中间
		str.replaceAll(" +",""); //去掉所有空格，包括首尾、中间
		str.replaceAll("\\s*", ""); //可以替换大部分空白字符， 不限于空格 ；
		\\s* 可以匹配空格、制表符、换页符等空白字符的其中任意一个。
 * @return  */
public class TrimTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "安   保";
		System.out.println("===========:"+name.trim());
		String str = " hi world ~ ";  
		//方法1：str.trim()
	    System.out.println("1--->"+str.trim());
	    //方法2：str.repalce(" ","")
	    System.out.println("2--->"+str.replace(" ", ""));
	    //方法3：str.repalceAll(" ","")
	    System.out.println("3--->"+str.replaceAll(" ", ""));
	    //方法4：str.repalceAll(" +","")
	    System.out.println("4--->"+str.replaceAll(" +", ""));
	    //方法5：str.repalceAll("\\s*","")
	    System.out.println("4--->"+str.replaceAll("\\s*", ""));
	}

}
