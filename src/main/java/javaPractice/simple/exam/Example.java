package javaPractice.simple.exam;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2017年9月27日 上午11:22:33
 * @version 1.0
 * @parameter
 * @since 人保考试测试题: 
 * str是按值传递，所以在函数中对bai它的操作只生效于它的副本，与原字符串du无关。
 * ch是按址传递，在函数中根据地址，可以直接对字符串进行操作。
 * @return good and gbc
 * 解答： https://blog.csdn.net/qq_25827845/article/details/52605633
 */
public class Example {
	String str = new String("good");
	char[] ch = { 'a', 'b', 'c' };

	public static void main(String args[]) {
		Example ex = new Example();
		ex.change(ex.str, ex.ch);
		System.out.println(ex.str + "and");
		System.out.println(ex.ch);
	}

	public void change(String str, char ch[]) {
		str = "test ok";
		ch[0] = 'g';
	}
}
