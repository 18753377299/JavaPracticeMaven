package javaPractice.simple.jiandanpaixu;

/**
 * * 冒泡排序
 *addby liqiankun 20190423
 * */
public class MaoPaoSort {
	public static void main(String []args) {
		double [] doubleArray = {3,6,5,2,12,56,34,64,43,35};
		MaoPaoSort.sortToMax(doubleArray);
	}

	
	public static void sortToMax(double []  doubleArray) {
		double temp;
		if(null!=doubleArray&&doubleArray.length>0) {
			for(int i=0;i<doubleArray.length;i++) {
				for(int j=i+1;j<doubleArray.length;j++) {
					if(doubleArray[i]>doubleArray[j]) {
						temp = doubleArray[i];
						doubleArray[i]= doubleArray[j];
						doubleArray[j]= temp;
					}
				}
			}
			for(int k=0;k<doubleArray.length;k++) {
				System.out.println(k+":"+doubleArray[k]);
			}
			System.out.println(doubleArray);
		}
	}
	
}
