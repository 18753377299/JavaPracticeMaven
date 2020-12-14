package javaPractice.simple.file;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月10日 下午3:47:31
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class ExportJsonToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String restring="1111";
			String filePath="E:\\1.asc";
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(restring.getBytes());
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
