package javaPractice.simple.whileFile;


/**
 * @功能：   outer: while (true) 的标签的用法
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月13日
 * @时间 下午4:55:20
 */
public class LabelWhile {
	public static void main(String[] args) {
		int intChgLength=0;
		String str="";
		for (int i = 0; i < intChgLength; i++) {
			str += "0";
		}
		System.out.println("aaaa"+str);
		
      int i = 0;
      outer: while (true) {
          System.out.println("Outer while loop");
          while (true) {
             i++;
             System.out.println("i= " + i);
             if (i == 1) {
                 System.out.println("continue");
                 continue;
             }
             if (i == 3) {
                 System.out.println("continue outer");
                 continue outer;
             }
             if (i == 5) {
                 System.out.println("break");
                 break;
             }
             if (i == 7) {
                 System.out.println("break outer");
                 break outer;
             }
         }
     }
   }
}
