package javaPractice.simple.file.readAndWrite;

import io.swagger.annotations.Api;

import java.io.FileOutputStream;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月10日 下午3:47:31
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
@Api(value="将字符串写到文件中")
public class ExportJsonToFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String restring="1111";
			String filePath="D:\\1.asc";
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(restring.getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
