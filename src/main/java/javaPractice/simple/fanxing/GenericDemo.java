package javaPractice.simple.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年7月15日 下午3:01:22
 * @version 1.0 
 * @parameter 来源： https://mp.weixin.qq.com/s/-2aKMj2Ugd9GXrwb8HJ5Fw
 * 	Java中所有的泛型必须是引用类型。Integer是引用类型，而int是基本类型。
 * 其他8种基本数据类型byte、short、int、long、float、double、char也都不是引用类型，
 * 所以8种基本数据类型都不能作为List的形参。但String、数组、class、interface是引用类型，
 * 都可以作为List的形参，所以存在List<Runnable>接口类型的集合、
 * List<int[]>数组类型的集合、List<String>类的集合。
 * 但不存在list<byte>、list<short> 等基本类型的集合。
 * @return  */
public class GenericDemo {

	public static void main(String[] args) {
		
		Info<Integer> info =fun(30);
		System.out.println(info.getVar());
		
		Pair<String ,String> p1 = new Pair<String ,String>("1","lqk");
		Pair<String ,String> p2 = new Pair<String ,String>("1","lqk");
		/*第一种：*/
		boolean result = GenericDemo.compare(p1, p2);
		System.out.println(result);
		/*第二种*/
		boolean resultTwo =  GenericDemo.<String ,String>compare(p1, p2);
		System.out.println(resultTwo);    
		
//		Integer [] array = {1,2,3,4,5};
//		Integer value = 3;
		/**疑问，待解答 */
//		int  count = countNum(array,value);
	}
	/*4、通配符
	Box<Number> n允许接受什么类型的参数？我们是否能够传入Box<Integer>或者Box<Double>呢？
	答案是否定的，虽然Integer和Double是Number的子类，但是在泛型中Box<Integer>或者
	Box<Double>与Box<Number>之间并没有任何的关系。
	这个时候使用通配符来解决这个问题: 这样可以把子类和父类关联上。
	*/
	static  void f2() {
		List<Apple> apples = new ArrayList<>();
		//为什么没有构造函数，默认一个无参的构造函数吗？？
		Reader<Fruit> fReader = new Reader<>();
		Fruit fruit =fReader.readTxt(apples);
	}
	
	/*5、PECS原则
	“Producer Extends” – 如果你需要一个只读List，用它来produce T，那么使用? extends T。
	“Consumer Super” – 如果你需要一个只写List，用它来consume T，那么使用? super T。
	如果需要同时读取以及写入，那么我们就不能使用通配符了。*/
	
	
	/*3、边界符：错误示例*/
	/*public static <T> int countNum(T [] array,T ele) {
		int count =0;
		for (T e: array) {
			使用“e > ele”这种形式就会报编译错误
			if(e > ele) {
				count ++;
			}
		}
		return count;
	} */
	public static <T extends Comparable<T>> int countNum(T [] array,T ele) {
		int count =0;
		for (T e: array) {
			if(e.compare(ele)>0) {
				count ++;
			}
		}
		return count;
	}
	
	
	/*泛型方法：声明一个泛型方法很简单，只要在返回类型前面加上一个类似<K, V>的形式就行了*/
	public static <T extends Number> Info<T> fun(T param){
		Info<T> info = new Info<T>();
		info.setVar(param);
		
		return info;
	}
	/*2、泛型的方法： 比较两个类中的值是否相等*/
	public static <K,V> boolean compare(Pair<K,V> p1,Pair<K,V> p2){
		return p1.getKey().equals(p2.getKey())&&p1.getValue().equals(p2.getValue());
	}

}

class Reader<T> {
	 T readTxt(List<? extends T> list) {
		return list.get(0);
	 }
}

interface Comparable<T> {
	public int compare(T o);
}

class Fruit{}
class Apple extends Fruit{}

/*1、泛型的类*/
class  Pair<K,V> {
	private K key;
	private V value;
	
	
	public Pair(K key, V value) {
		super();
		this.key = key;
		this.value = value;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	
}



class Info<T extends Number>{
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}

	@Override
	public String toString() {
		return this.var.toString();
	}
}
