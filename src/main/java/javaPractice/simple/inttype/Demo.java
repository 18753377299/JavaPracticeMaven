package javaPractice.simple.inttype;

/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年6月26日 下午5:38:38
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class Demo {

//	  public static void main(String args[]) { 
//          char c = 'A' ; 
//          int num = 10 ; 
//          switch(c) { 
//              case 'B' : 
//                  num ++ ; 
//              case 'A' : 
//                  num ++ ; 
//              case 'Y' : 
//                  num ++ ; 
//                  break ; 
//              default : 
//                  num -- ; 
//          } 
//          System.out.println(num) ; 
//      } 
	
	 public static void main(String args[]) { 
         int num = 2147483647 ; 
         long temp = num + 2L ; 
         num+=2;
         int i=1;
         int j=2;
         // 初始化的问题
         int l,m,n;
         l=0;m=0;n=0;
         l= ++ l;
         System.out.println("l:"+l+",m:"+m+",n:"+n);
         int max=Integer.MAX_VALUE;
         System.out.println("max="+max);
         System.out.println(num) ; 
         System.out.println(temp);
         System.out.println("i+j="+i+","+j);
     } 

}
