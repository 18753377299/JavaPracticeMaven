package javaPractice.simple.fileOperate;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/*从txt中读取文件内容*/
public class FileReadFromTxt {

	 public static void main(String[] args){
	        File file = new File("D:/test123.txt");
	        System.out.println(txt2String(file));
	 }
	 public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
        	//构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));       
            String s = null;
            while((s = br.readLine())!=null){
                //使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            System.out.println(result.toString());
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

}
