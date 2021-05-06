package javaPractice.simple.fileOperate.image.main;

import javaPractice.simple.fileOperate.image.captcha.Captcha;
import javaPractice.simple.fileOperate.image.captcha.GifCaptcha;
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

public class GenerateImage {
    public static void main(String[] args) {
//        String url = "https://dpic.tiankong.com/be/bt/QJ6224075606.jpg?x-oss-process=style/794ws";
        String url = "http://127.0.0.1:8079/Desktop/hashSet.PNG";
        String strBase64 ="";
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        Captcha captcha = new GifCaptcha();
        captcha.out(outStream);

        byte[] bytes = outStream.toByteArray();
        BASE64Encoder encoder = new BASE64Encoder();
        strBase64 = encoder.encode(bytes);
        System.out.println("===>" + strBase64);

//        captcha.out(getImage(url));
    }
    public static ByteArrayOutputStream  getImage(String imageURL){
        String strBase64 = null;
        DataInputStream dataInputStream = null;
        ByteArrayOutputStream outStream = null;
        String imageUrl = "";
        try {
            imageUrl = URLDecoder.decode(imageURL, "UTF-8");
            URL url;
            url = new URL(imageUrl);
            dataInputStream = new DataInputStream(url.openStream());

            outStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];

            int len = 0;
            while ((len = dataInputStream.read(buffer)) != -1) {
                outStream.write(buffer, 0, len);
            }
            // in.available()返回文件的字节长度
            byte[] bytes = outStream.toByteArray();
            // 将文件中的内容读入到数组中
            dataInputStream.read(bytes);
//	            strBase64 = Base64.encodeBase64String(bytes);
            BASE64Encoder encoder = new BASE64Encoder();
            strBase64 = encoder.encode(bytes);
//	        strBase64 = Base64.getEncoder().encodeToString(bytes);
//	            strBase64 = new BASE64Encoder().encode(bytes);      //将字节流数组转换为字符串


        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (outStream != null) {
                    outStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("文件流关闭异常:" + e);
            }
        }

        return outStream;
    }
}
