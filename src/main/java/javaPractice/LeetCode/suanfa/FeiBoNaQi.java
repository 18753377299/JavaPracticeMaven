package javaPractice.LeetCode.suanfa;

import io.swagger.annotations.Api;


@Api("斐波那契数列(前两位的和等于第三位数)： 1,1,2,3,5...")
public class FeiBoNaQi {
    public static void main(String []args){
        int n =10;
        System.out.println(feiBoNaQi(n));
    }

    public static int feiBoNaQi(int n){
        if(n==1){
            return 1;
        }
        if(n ==2){
            return 1;
        }
        return feiBoNaQi(n-1) +feiBoNaQi(n-2);
    }


}
