package javaPractice.simple.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年9月24日 下午2:43:21
 * @version 1.0 
 * @parameter  设置代理成功请求台风数据
 * @since  
 * @return  */
public class HttpGetSend {
	public static void main(String []args){
		 String urlString="http://60.205.166.252/typhoon/getTyphoonFstNew?startTime=20191201000000&endTime=20191225000000&secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=U7WJVZDK8PDNM9W1APFTFMJ1DK";
		String result  = get(urlString);
		System.out.println(result);
	}
    public static String get(String url)  {
    	 StringBuffer sb = new StringBuffer();
    	 BufferedReader in = null;
        try {
			URL realUrl = new URL(url);
			// 设置代理请求
//           Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("Proxy.piccnet.com.cn",3128));
//           HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection(proxy);
			// 打开和URL之间的连接
			HttpURLConnection connection = (HttpURLConnection)realUrl.openConnection();
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
}
