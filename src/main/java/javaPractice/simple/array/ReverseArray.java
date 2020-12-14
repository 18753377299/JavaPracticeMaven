package javaPractice.simple.array;


/**
 * @功能：
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月22日
 * @时间 下午7:21:49
 */
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 可以指定数据的长度
		Reverse reverse =new Reverse(3);
		System.out.print(reverse.add(11)+"、");
		System.out.print(reverse.add(8)+"、");
		System.out.print(reverse.add(9)+"、");
		System.out.println(reverse.add(7)+"、");
		print(reverse.getTemp());
	}

	static void print(int [] data ) {
		for(int i=0;i<data.length;i++) {
			System.out.print(data[i]+"\t");
		}
	}
}

class Reverse{
	
	private int [] temp;
	private int  index;
	
	public Reverse(int len) {
		super();
		if(len>0) {
			temp = new int[len];
		}else {
			temp = new int[1];
		}
	}

	public boolean add(int data) {
		if(index<temp.length) {
			temp[index] =  data;
			index++;
			return true;
		}else {
			
			return false;
		}
	}

	public int [] getTemp() {
		return this.temp;
	}
	
	
}
