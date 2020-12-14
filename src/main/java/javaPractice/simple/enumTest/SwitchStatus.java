package javaPractice.simple.enumTest;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月30日 上午9:52:58
 * @version 1.0 
 * @parameter  需要为枚举类定义枚举元素 至少一个,当定义属性时,
 * 否则会爆出Syntax error on token "String", strictfp expected 这个错误并且要为枚举类定义属性构造器
 * @since  
 * @return  */
public enum SwitchStatus {
	/*枚举通常被当做常量使用，如果枚举中存在公共属性字段或设置字段方法，
	那么这些枚举常量的属性很容易被修改；理想情况下，枚举中的属性字段
	是私有的，并在私有构造函数中赋值，没有对应的Setter 方法，最好加上final 修饰符。*/
		// 枚举的属性字段正例
		DISABLED(0,"禁用"),
		ENABLED(1,"启用");
		
		// final 修饰
		 private final int  value;
		 private final String description;
		 
		 private SwitchStatus(int value, String description) {
			this.value = value;
			this.description = description;
		 }

			public int getValue() {
				return value;
			}
		
			public String getDescription() {
				return description;
			}
	 
}
