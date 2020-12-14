package javaPractice.simple.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年10月10日 下午5:07:07
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class ReadUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath ="http://10.10.2.241:5001/riskcontrol_file/downloadSuperMap/mapGridData.asc";
		String jsonString = get(filePath);
		System.out.println("end");
	}
	public static String get(String url)  {
   	 StringBuffer sb = new StringBuffer();
   	 BufferedReader in = null;
       try {
			URL realUrl = new URL(url);
			// 设置代理请求
//          Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("Proxy.piccnet.com.cn",3128));
//          HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection(proxy);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
//			connection.setRequestProperty("accept", "*/*");
//			connection.setRequestProperty("connection", "Keep-Alive");
//			connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);
			// 建立实际的连接
			connection.connect();
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
     
			String line;
			while ((line = in.readLine()) != null) {
			    sb.append(line);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
           try {
           	in.close();
           } catch (Exception ex) {
               return "0";
           }
       }
       return sb.toString();
   }
	
	public static String ReadUrl(String FileName){
	   String read;
	   String readStr ="";
		try{
		      URL   url   =new   URL(FileName);
		      HttpURLConnection   urlCon   =   (HttpURLConnection)url.openConnection();
		      urlCon.setConnectTimeout(5000);
		      urlCon.setReadTimeout(5000);
		      
		      BufferedReader br =new BufferedReader(new InputStreamReader( urlCon.getInputStream()));
		      while ((read = br.readLine()) !=null) {
		              readStr = readStr + read;
		      }
		      br.close();
		   }
		catch (IOException e) {
		// TODO Auto-generated catch block
		   readStr ="f";
		  }
	  return readStr;
	}

}
