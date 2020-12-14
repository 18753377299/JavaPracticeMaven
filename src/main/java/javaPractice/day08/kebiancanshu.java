package javaPractice.day08;

public class kebiancanshu {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	  int a=sum1(new int[]{1,2,3,4});
	  int b=sum2(new int[]{1,2,3,4});
	  int c=sum2(new int[]{1,2,3});
//	  System.out.println("a="+a);
	  System.out.println("b="+b);
	  System.out.println("c="+c);
	  sum1(new int[]{1,2,3});

	}
	 public  static void  sum1(int[] arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		System.out.println("sum="+sum);
//		return sum;
		
	}
	 static int sum2(int... arr){
		int sum=0;
		for(int i=0;i<arr.length;i++){
			sum+=arr[i];
		}
		return sum;
		
	}

}
