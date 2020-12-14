package javaPractice.simple.array;

import java.util.Arrays;

// 进行数组初始化
public class InitArray {
      public static void main(String []args){
          /*一维数组*/
          int []  arrayOne = {1,4,3,5};
          int [] arrayTwo = new int[5];
          int [] arryThree = new int []{3,6,4,3};

          System.out.println(Arrays.toString(arrayOne));
          System.out.println(Arrays.toString(arrayTwo));
          System.out.println(Arrays.toString(arryThree));

          /*二维数组*/

          String [] [] twoArray = {{"A","B"},{"C","D"}};
         /* 输出二维数组的值*/
          System.out.println(Arrays.deepToString(twoArray));

       }
}
