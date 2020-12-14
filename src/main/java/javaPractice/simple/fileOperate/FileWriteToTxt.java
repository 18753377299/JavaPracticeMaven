package javaPractice.simple.fileOperate;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

/*将数据写入到txt文件中*/
public class FileWriteToTxt {

	public static void main(String[] args) {
		for(int i =0;i<10;i++){
			String fiePath="D:/lqk/";
			String name ="test"+i+".txt";
			fiePath = fiePath+name;
			writeToFile(fiePath);
		}

	}
	/*将数据输出到文件中*/
	public static  void writeToFile (String fiePath){
		File file = null;
        FileWriter fw = null;
        file = new File(fiePath);
        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
        	// 如果输出目标文件夹不存在，则创建
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            fw = new FileWriter(file);
            for(int i = 1;i <=3000;i++){
            fw.write("abcdefgabcdefg"+i+",");             //向文件中写内容
            fw.write("sssssssssssssss"+i+",\r\n");       //加上换行
            fw.flush();
            }
            System.out.println("写数据成功！");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(fw != null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	 public static byte[] getBytes(char[] chars) {
	        Charset cs = Charset.forName("UTF-8");
	        CharBuffer cb = CharBuffer.allocate(chars.length);
	        cb.put(chars);
	        cb.flip();
	        ByteBuffer bb = cs.encode(cb);
	        return bb.array();
	    }
	 
	    public static char[] getChars(byte[] bytes) {
	        Charset cs = Charset.forName("UTF-8");
	        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
	        bb.put(bytes).flip();
	        CharBuffer cb = cs.decode(bb);
	        return cb.array();
	    }

}
