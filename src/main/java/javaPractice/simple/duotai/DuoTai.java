package javaPractice.simple.duotai;

/**
 * @功能：
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年7月3日
 * @时间 下午2:33:26
 */
public class DuoTai {
   public static void main(String []args) {
	   DB db =new DB();
	   db.print1();
	   db.print2();
	   db.print3();
	   
//	   DA da = new DB();
//	   DB db =(DB)da;
//	   db.print1();
//	   db.print2();
//	   db.print3();
	   
   }
}
class DA{
	public void print1() {
		System.out.println("==================DA==print1");
	}
	public void print2() {
		System.out.println("==================DA==print2");
	}
}
class DB extends DA{
	
	public void print1() {
		System.out.println("==================DB==print1");
	}
	public void print3() {
		System.out.println("==================DB==print3");
	}
}

