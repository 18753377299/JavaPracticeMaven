package javaPractice.simple.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月10日 下午4:00:31
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class ReadFileContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String fileName = "C:/Users/Administrator/Desktop/Noname1.txt";
		String fileName = "C:/Users/Administrator/Desktop/aaaaa.asc";  
//		readFileByBytes(fileName);
		String  ascstring =  readFileByLines(fileName);
		//生成asc文件
		generateAscFile(ascstring);
	}
	// 生成文件
	public static void generateAscFile(String restring){
		try {
//			String restring="1111";
			String filePath="E:\\2.asc";
			FileOutputStream fos = new FileOutputStream(filePath);
			fos.write(restring.getBytes());
			fos.close();
			System.out.println("success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 /** 
     * 以行为单位读取文件，常用于读面向行的格式化文件 
     */  
    public static String readFileByLines(String fileName) { 
    	StringBuffer stringBuffer = new StringBuffer();
    	
        File file = new File(fileName);  
        BufferedReader reader = null;  
        try {  
            System.out.println("以行为单位读取文件内容，一次读一整行：");  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
            int line = 1;  
            // 一次读入一行，直到读入null为文件结束  
            while ((tempString = reader.readLine()) != null) {  
                // 显示行号  
//                System.out.println("line " + line + ": " + tempString);  
                stringBuffer.append(tempString+"\n");
                line++;  
            }  
            System.out.println(stringBuffer.toString()); 
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return stringBuffer.toString();
    }  
	/** 
     * 以字节为单位读取文件，常用于读二进制文件，如图片、声音、影像等文件。 
     */  
    public static void readFileByBytes(String fileName) {  
        File file = new File(fileName);  
        InputStream in = null;  
        try {  
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");  
            // 一次读一个字节  
            in = new FileInputStream(file);  
            int tempbyte;  
            while ((tempbyte = in.read())!=-1) {  
                System.out.println(tempbyte);  
            }  
        } catch (Exception e) {  
            // TODO: handle exception  
            e.printStackTrace();  
        }  
      }

}
