package javaPractice.simple.StringSplice;


/*https://mp.weixin.qq.com/s/adnP0a7_6BV9-oD207kJNA
*/

public class StringMain {
	public static void main(String[] args) {
		/*在class文件中有一部分 来存储编译期间生成的 字面常量以及符号引用，
		 * 这部分叫做class文件常量池，在运行期间对应着方法区的运行时常量池.
		 * 1、String str1 = "hello world";和String str3 = "hello world"; 
		 * 都在编译期间生成了 字面常量和符号引用，运行期间字面常量"hello world"被存储在运行时常量池（当然只保存了一份）。
		 * 通过这种方式来将String对象跟引用绑定的话，JVM执行引擎会先在运行时常量池查找是否存在相同的字面常量，如果存在，
		 * 则直接将引用指向已经存在的字面常量；否则在运行时常量池开辟一个空间来存储该字面常量，并将引用指向该字面常量。
		 * 2、通过new关键字来生成对象是在堆区进行的，而在堆区进行对象生成的过程是不会去检测该对象是否已经存在的。
		 * 因此通过new来创建对象，创建出的一定是不同的对象，即使字符串的内容是相同的。
		 * 3、对于被final修饰的变量，会在class文件常量池中保存一个副本，也就是说不会通过连接而进行访问，
		 * 对final变量的访问在编译期间都会直接被替代为真实的值。
		 * 那么String c = b + 2;在编译期间就会被优化成：String c = "hello" + 2;
		 * */
	       String str1 = "hello world";
	       String str2 = new String("hello world");
	       String str3 = "hello world";
	       String str4 = new String("hello world");
	       
	       /*false,true,false*/
	       System.out.println(str1==str2);
	       System.out.println(str1==str3);
	       System.out.println(str2==str4);
	       
	       
	      /* 2）String、StringBuilder、StringBuffer三者的执行效率：
	     　　StringBuilder > StringBuffer > String
	     	当然这个是相对的，不一定在所有情况下都是这样。
	　　	比如String str = "hello"+ "world"的效率就比
	 	StringBuilder st  = new StringBuilder().append("hello").append("world")要高。
	     */
	       
	       
	   }
}
