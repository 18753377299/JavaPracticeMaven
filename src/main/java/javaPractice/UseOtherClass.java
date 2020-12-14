package javaPractice;

public class UseOtherClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person person=new Person();
		person.useAxe(); // 空指针异常
//		Axe axe =new Axe();
		// 能够调用成功，所以如果想要 成功的话，需要我们使用spring注入
//		System.out.println(axe.chop());  
	}
	
}
class Axe{
	public String chop(){
		return "chop";
	}
}
class Person{
	private Axe axe;

	public void setAxe(Axe axe) {
		this.axe = axe;
	}
	public void useAxe(){
		System.out.println(axe.chop());
	}
	
}
