package javaPractice.simple.thread_10;

import io.swagger.annotations.ApiOperation;

/**
 * @功能：单线程
 * @author liqiankun
 * @param            
 * @throws
 * @日期 2019年6月22日
 * @时间 下午4:35:03
 */
public class OnlyThread extends Thread{

	@ApiOperation(value="使用Thread来实现单线程")
	public static void main(String [] args){
		OnlyThread td =new OnlyThread();		
		td.start();   
	}

	public void run(){
		for(int row=1,count=1;row<10;row++,count++){
			for(int i=0; i<count;i++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
