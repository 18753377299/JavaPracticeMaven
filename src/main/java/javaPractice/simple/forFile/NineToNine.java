package javaPractice.simple.forFile;

public class NineToNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*第一种*/
		for(int i=1;i<=9;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		System.out.println();
		/*第二种*/
		for(int i=9;i>0;i--) {
			for(int j=9;j>=i;j--) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		System.out.println();
		/*第三种*/
		for(int i=1;i<=9;i++) {
			for(int k=0;k<9-i;k++) {
				System.out.print("\t");
			}
			for(int j=1;j<=i;j++) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		System.out.println();
		/*第四种*/
		for(int i=9;i>0;i--) {
			for(int j=9;j>9-i;j--) {
				System.out.print(j+"*"+i+"="+i*j+"\t");
			}
			System.out.println();
		}
		System.out.println();
	}
	

}
