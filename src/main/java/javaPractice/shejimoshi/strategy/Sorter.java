package javaPractice.shejimoshi.strategy;

public class Sorter {
    public void sort( int [] array) {
    	for(int i =0;i<array.length;i++) {
    		for(int j=i+1;j<array.length;j++) {
    			if (array[j] <array[i]) {
    				swap(array,i,j);
    			}
    		}
    	}
//    	for(int k=0;k<array.length;k++) {
//    		System.out.print(array[k]+" ");
//    	}
    	System.out.println(array.toString());
    }
    public  void swap(int []array,  int i,int j ) {
    	int result;
    	result = array[i];
    	array[i]= array[j];
    	array[j]= result;
    }
}
