package javaPractice.simple.map;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javaPractice.simple.enumTest.SwitchStatus;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Result;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月29日 下午4:38:23
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class MapUpdate {
	/*七、使用静态代码块实现赋值静态成员变量*/
	/*对于集合类型的静态成员变量，应该使用静态代码块赋值，而不是使用集合实现来赋值。*/
	//赋值静态成员变量反例
	//赋值静态成员变量反例
	private static Map<String, Integer> map = new HashMap<String, Integer>(){{
	        put("Leo",1);
	        put("Family-loving",2);
	        put("Cold on the out side passionate on the inside",3);
	    }};
	private static List<String> list = new ArrayList<String>(){
	    {
	        add("Sagittarius");
	        add("Charming");
	        add("Perfectionist");
	    }
	};
	//赋值静态成员变量正例
	private static Map<String, Integer> mapNew = new HashMap<String, Integer>();
	static {
		mapNew.put("Leo",1);
		mapNew.put("Family-loving",2);
		mapNew.put("Cold on the out side passionate on the inside",3);
	}

	private static List<String> listNew = new ArrayList<>();
	static {
		listNew.add("Sagittarius");
		listNew.add("Charming");
		listNew.add("Perfectionist");
	}
	public static void main(String[]args){
		MapUpdate.checkIsNull();
		MapUpdate.transferStr();
		MapUpdate.testBigDecimal();
		MapUpdate.testEnum();
		MapUpdate.testString();
	}
	public void operateMap(){
		//Map 获取value 反例:
		HashMap<String, String> map = new HashMap<>();
		for (String key : map.keySet()){
		    String value = map.get(key);
		}
		/*二、迭代entrySet() 获取Map 的key 和value*/
		/*当循环中只需要获取Map 的主键key时，迭代keySet() 是正确的；
		但是，当需要主键key 和取值value 时，迭代entrySet() 才是更高效的做法，
		其比先迭代keySet() 后再去通过get 取值性能更佳。*/
		Map<String,String> mapNew = new HashMap<String,String>();
		for (Map.Entry<String,String> entry: mapNew.entrySet()){
			String key = entry.getKey();
			String value = entry.getValue();
		}
		/*六、若需频繁调用Collection.contains 方法则使用Set*/
		/*在Java 集合类库中，List的contains 方法普遍时间复杂度为O(n)，
		若代码中需要频繁调用contains 方法查找数据则先将集合list 
		转换成HashSet 实现，将O(n) 的时间复杂度将为O(1)*/
		//频繁调用Collection.contains() 反例
		List<Object> list = new ArrayList<>();
		for (int i = 0; i <= Integer.MAX_VALUE; i++){
		    //时间复杂度为O(n)
		    if (list.contains(i))
		    System.out.println("list contains "+ i);
		}
		//频繁调用Collection.contains() 正例
//		List<Object> list = new ArrayList<>();
		Set<Object> set = new HashSet<>();
		for (int i = 0; i <= Integer.MAX_VALUE; i++){
		    //时间复杂度为O(1)
		    if (set.contains(i)){
		        System.out.println("list contains "+ i);
		    }
		}
		
	}
	// 三、Collection.isEmpty()检测 非空 
	/*使用Collection.size() 来检测是否为空在逻辑上没有问题，但是使用Collection.isEmpty()
	使得代码更易读，并且可以获得更好的性能；除此之外，任何Collection.isEmpty() 
	实现的时间复杂度都是O(1) ，不需要多次循环遍历，但是某些通过Collection.size() 
	方法实现的时间复杂度可能是O(n)*/
	public static boolean checkIsNull(){
		/*反例*/
		LinkedList<Object> linkedList = new LinkedList<Object>();
		if(linkedList.size()==0){
			System.out.println("size");
		}
		/*正例：*/
		LinkedList<Object> linkedListNew =null;
		if(linkedListNew==null || linkedListNew.isEmpty()){
			System.out.println("empty");
		}
		if(CollectionUtils.isEmpty(linkedListNew)){
			System.out.println("CollectionUtils isEmpty");
		}
		return true;
	}
	/*四、初始化集合时尽量指定其大小*/
	/*尽量在初始化时指定集合的大小，能有效减少集合的扩容次数，因为集合每次扩容的时间复杂度很可能时O(n)，耗费时间和性能。*/
	public  void initList(){
		int [] arr = {1,2,3,4,5};
		List<Integer> list = new ArrayList<Integer>(arr.length);
		for(int i: arr){
			list.add(i);
		}
	}
	/*五、使用StringBuilder 拼接字符串*/
	/*一般的字符串拼接在编译期Java 会对其进行优化，但是在循环中字符串的拼接Java 
	编译期无法执行优化，所以需要使用StringBuilder 进行替换。*/
	public void spliceStr(){
		//在循环中拼接字符串反例
		String str = "";
		for (int i = 0; i < 10; i++){
		    //在循环中字符串拼接Java 不会对其进行优化
		    str += i;
		}
		
		//在循环中拼接字符串正例
		String str1 = "Love";
		String str2 = "Courage";
		String strConcat = str1 + str2;  //Java 编译器会对该普通模式的字符串拼接进行优化
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++){
		   //在循环中，Java 编译器无法进行优化，所以要手动使用StringBuilder
		    sb.append(i);
		}
	}
	
	/*八、删除未使用的局部变量、方法参数、私有方法、字段和多余的括号*/
	/*九、工具类中屏蔽构造函数*/
	/*工具类是一堆静态字段和函数的集合，其不应该被实例化；
	但是，Java 为每个没有明确定义构造函数的类添加了一个隐式公有构造函数，
	为了避免不必要的实例化，应该显式定义私有构造函数来屏蔽这个隐式公有构造函数。*/
	
	/*十一、字符串转化使用String.valueOf(value) 代替 " " + value*/
	/*把其它对象或类型转化为字符串时，使用String.valueOf(value) 比 ""+value 的效率更高。*/
//	static int numnew ;   // 直接输出为0 
	static Integer numnew ;   // 直接输出为null
	public static void transferStr(){
		try {
			//把其它对象或类型转化为字符串反例：
			int num = 520;
			// "" + value
			String strLove = "" + num;
			System.out.println(strLove);
		/*只要不是类字段和数组，其它变量一律要赋值。*/
//		int numnew ;
			String love = String.valueOf(numnew);
			System.out.println(love);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*十二、避免使用BigDecimal(double)*/
	/*BigDecimal(double) 存在精度损失风险，在精确计算或值比较的场景中可能会导致业务逻辑异常。*/
	public static void testBigDecimal(){
//		反例：
		BigDecimal bigDecimal = new BigDecimal(0.11D);
		// 输出的值如下： 0.11000000000000000055511151231257827021181583404541015625
		System.out.println(bigDecimal);  
//		正例：
		BigDecimal bigDecimal2 = BigDecimal.valueOf(0.11D);
		// 输出的值如下： 0.11
		System.out.println(bigDecimal2);
	}
	/*十三、返回空数组和集合而非 null*/
	/*若程序运行返回null，需要调用方强制检测null，否则就会抛出空指针异常；
	返回空数组或空集合，有效地避免了调用方因为未检测null 而抛出空指针异
	常的情况，还可以删除调用方检测null 的语句使代码更简洁。*/
//	反例：
	//返回null 反例
	public static Result [] getResults() {
	    return null;
	}
	public static List<Result> getResultList() {
	    return null;
	}
	public static Map<String, Result> getResultMap() {
	    return null;
	}
//	正例：
	//返回空数组和空集正例
	public static Result[] getResultsNew() {
	    return new Result[0];
	}

	public static List<Result> getResultListNew() {
	    return Collections.emptyList();
	}

	public static Map<String, Result> getResultMapNew() {
	    return Collections.emptyMap();
	}
	/*十四、优先使用常量或确定值调用equals 方法*/
	/*对象的equals 方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals 方法。*/
//	反例：
	//调用 equals 方法反例
	private static boolean fileReader(String fileName)throws IOException{

	 // 可能抛空指针异常
	 return fileName.equals("Charming");
	}
//	正例：
	//调用 equals 方法正例
	private static boolean fileReaderNew(String fileName)throws IOException{

	    // 使用常量或确定有值的对象来调用 equals 方法
//	    return "Charming".equals(fileName);

	    //或使用：java.util.Objects.equals() 方法
	   return Objects.equals("Charming",fileName);
	}
	/*十五、枚举的属性字段必须是私有且不可变*/
	/*枚举通常被当做常量使用，如果枚举中存在公共属性字段或设置字段方法，
	那么这些枚举常量的属性很容易被修改；理想情况下，枚举中的属性字段
	是私有的，并在私有构造函数中赋值，没有对应的Setter 方法，最好加上final 修饰符。*/
	
	public static void testEnum(){
		//对枚举类型的数进行操作
		SwitchStatus [] switchs = SwitchStatus.values();
		for (SwitchStatus status: switchs){
			System.out.println(status.name()); 
		}
	}
	/*十六、tring.split(String regex)部分关键字需要转译*/
	/*使用字符串String 的plit 方法时，传入的分隔字符串是正则表达式，则部分关键字（比如 .[]()| 等）需要转义。*/
	public static void testString(){
		// String.split(String regex) 正例
		// . 需要转译
		String[] split2 = "a.ab.abc".split("\\.");
		System.out.println(Arrays.toString(split2));  // 结果为["a", "ab", "abc"]

		// | 需要转译
		String[] split3 = "a|ab|abc".split("\\|");
		System.out.println(Arrays.toString(split3));  // 结果为["a", "ab", "abc"]
	}

	

}
