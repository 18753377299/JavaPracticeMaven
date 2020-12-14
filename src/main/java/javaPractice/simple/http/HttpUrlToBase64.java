package javaPractice.simple.http;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import sun.misc.BASE64Encoder;

import com.common.utils.FileUtils;

public class HttpUrlToBase64 {
	public static void main(String []args){
//		String path ="";
		String path ="http://10.156.130.74:30131/zt/c012-0000-gn/00012003/imageGetFile?data=aHR0cDovL2Nvcy1rYy1kZXYtcDAzLTUtMS0xMjU1MDAwMDI3LmNvcy5iai5jb3MudGNlLnBpY2NpdC5jbi8wMDAwL3Jpc2tDb250cm9sLzIwMjAvMDYvMjQvMjcvNjIvMTBjY2Q0NTQ3ZWM5YzczYzRiOGQ1NTBjYzhmNjMyN2QzN18xLzRFNTMwQTZDLThDREEtNEYyQi0zRjQ3LUQwMEY4MkU4MkI5MC5qcGc/c2lnbj1xLXNpZ24tYWxnb3JpdGhtJTNEc2hhMSUyNnEtYWslM0RBS0lERUN1TUZyQkYxWG1qUXlDMWxiYkxvOUYyanR5YWFTNXMlMjZxLXNpZ24tdGltZSUzRDE1OTMzNDEzODElM0IxNTkzMzQzMTgxJTI2cS1rZXktdGltZSUzRDE1OTMzNDEzODElM0IxNTkzMzQzMTgxJTI2cS1oZWFkZXItbGlzdCUzRCUyNnEtdXJsLXBhcmFtLWxpc3QlM0QlMjZxLXNpZ25hdHVyZSUzRGViNDVmZTIxYjNiODcyMWU0MzQwMTQzNDNkYmZlMzQwOWQ3MDQyYzA=";
		try {
			path = URLDecoder.decode(path, "UTF-8");
			String  returnJson =encodeImageToBase64(path);
//			String  returnJson = getImageBase(path);
			FileUtils.writeToFile(returnJson,"D:/aab.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * @功能：图片转化base64
	 * @author 马军亮
	 * @param imagePath 图片路径
	 * @日期：2018-1-11
	 */
	public static String  getImageBase(String imageURL) {
		 String strBase64 = null;
		 DataInputStream dataInputStream = null;
    	 ByteArrayOutputStream outStream = null;
 		 HttpURLConnection conn = null;
	        try {
	        	URL url = new URL(imageURL);
//	        	String imageUrl = "";
//	    		imageUrl = URLDecoder.decode(imageURL, "UTF-8");
//	    		URL url;
//	    		url = new URL(imageUrl);
	    		
	    		conn = (HttpURLConnection) url.openConnection();
	    		//设置请求方式为"GET"
//	    		conn.setRequestMethod("GET");
	    		//超时响应时间为5秒
	    		conn.setConnectTimeout(50000);
	    		conn.setReadTimeout(50000);
	    		conn.setRequestProperty("Content-type", "application/json");
	    		conn.setRequestProperty("authorization", "BackType eyJhbGciOiJIUzI1NiJ9.eyJhcHBseU1pY3JvU2VydmljZUNvZGUiOiIwMTAxNDAxMyIsImV4cCI6MTY4MzkwNzIwMDAwMH0.He0U5gCgasoKm1dKYgmhF2btqBxkt3ayz2UCz23uFOE");
	    		//通过输入流获取图片数据
//	    		InputStream inStream = conn.getInputStream();
	    		
//	    		dataInputStream = new DataInputStream(url.openStream());
	    		dataInputStream = new DataInputStream(conn.getInputStream());
	    		
	    		outStream = new ByteArrayOutputStream();
	    		
	    		byte[] buffer = new byte[1024];
	             
	            int len = 0;
	            while( (len=dataInputStream.read(buffer)) != -1 ){
	            	outStream.write(buffer, 0, len);
	            }
	            // in.available()返回文件的字节长度
	            byte[] bytes = outStream.toByteArray();
	            // 将文件中的内容读入到数组中
	            dataInputStream.read(bytes);
//	            strBase64 = Base64.encodeBase64String(bytes);
	            BASE64Encoder encoder = new BASE64Encoder(); 
	            strBase64 = encoder.encode(bytes);
//	            strBase64 = Base64.getEncoder().encodeToString(bytes);
//	            strBase64 = new BASE64Encoder().encode(bytes);      //将字节流数组转换为字符串
	            dataInputStream.close();
//	            StringToImage(strBase64);
//	            ajaxResult.setData(strBase64);
//	            ajaxResult.setStatusText("成功");
//				ajaxResult.setStatus(1);
	        } catch (Exception e) {
//	        	ajaxResult.setStatusText("失败");
//				ajaxResult.setStatus(0);
	            e.printStackTrace();
	            throw new RuntimeException("图片转化异常:"+e);
	        }finally{
	        	try {
	        		dataInputStream.close();
					outStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					 throw new RuntimeException("文件流关闭异常:"+e);
				}
	        }
	        System.out.println(strBase64);
	        return strBase64;
	}
	
	
	/**
	* 将网络图片编码为base64
	*
	* @param url
	* @return
	* @throws BusinessException
	*/
	public static String encodeImageToBase64(String path) throws Exception {
		URL url = new URL(path);
		//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
		System.out.println("图片的路径为:" + url.toString());
		//打开链接
		HttpURLConnection conn = null;
		try {
//		   String proxyHost = "Proxy.piccnet.com.cn";
//		   int proxyPort = 3128;
//          Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress(proxyHost,proxyPort));
//          conn = (HttpURLConnection) url.openConnection(proxy);
		conn = (HttpURLConnection) url.openConnection();
		//设置请求方式为"GET"
//		conn.setRequestMethod("GET");
		//超时响应时间为5秒
		conn.setConnectTimeout(50000);
		conn.setReadTimeout(50000);
		conn.setRequestProperty("Content-type", "application/json");
		conn.setRequestProperty("authorization", "BackType eyJhbGciOiJIUzI1NiJ9.eyJhcHBseU1pY3JvU2VydmljZUNvZGUiOiIwMTAxNDAxMyIsImV4cCI6MTY4MzkwNzIwMDAwMH0.He0U5gCgasoKm1dKYgmhF2btqBxkt3ayz2UCz23uFOE");
		//通过输入流获取图片数据
		InputStream inStream = conn.getInputStream();
		//得到图片的二进制数据，以二进制封装得到数据，具有通用性
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		//创建一个Buffer字符串
		byte[] buffer = new byte[1024];
		//每次读取的字符串长度，如果为-1，代表全部读取完毕
		int len = 0;
		//使用一个输入流从buffer里把数据读取出来
		while ((len = inStream.read(buffer)) != -1) {
			//用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
			outStream.write(buffer, 0, len);
		}
		//关闭输入流
		inStream.close();
		byte[] data = outStream.toByteArray();
		//对字节数组Base64编码
		BASE64Encoder encoder = new BASE64Encoder();
		String base64 = encoder.encode(data);
		System.out.println(base64);
		return base64;//返回Base64编码过的字节数组字符串
		} catch (IOException e) {
			e.printStackTrace();
			throw new Exception("图片上传失败,请联系客服!");
		}
	}
}
