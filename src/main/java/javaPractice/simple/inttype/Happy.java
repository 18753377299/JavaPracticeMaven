package javaPractice.simple.inttype;

/**
 * @author  作者 E-mail: 
 * @date 创建时间：2017年6月26日 下午5:32:35
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class Happy {

	 public static void main(String args[])     { 
         int i = 1 ;     
         int j = i++ ; 
         if((i==(++j))&&((i++)==j))     { 
             i += j ; 
         } 
         System.out.println("i = "+i); 
     } 

}
