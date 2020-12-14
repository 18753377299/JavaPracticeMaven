package javaPractice.simple.http;

import java.io.IOException;

import net.bytebuddy.asm.Advice.This;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.params.ConnRouteParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;



public class SendPostRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		String url = "http://60.205.166.252/renbaofile/FileProvider/downloadFileByJson?secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=YYUTAKPEV6Y4F3P8NQZD3CWF5J&Content-type=application/text";
		String result = sendPostRequest(url,generateJson().toString(),"UTF-8","");
		System.out.println("success");
	}
	
	public static JSONObject generateJson() {
		// 推送目标
		JSONObject audience = new JSONObject();
		audience.put("pattern", "name");
		audience.put("type", "fst");
		//数组
		JSONArray platform = new JSONArray();
		//数组中对象
		JSONObject message = new JSONObject();
		message.put("file_name", "Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201909270800.json");
		platform.add(message);
		// 将数组添加到大对象中
		audience.put("files", platform);
		return audience;
	}
	/**
	 * @功能：发送Post请求（json格式） @param pushUrl,data,encodeCharset,authorization
	 * @return String
	 * 	@日期：2018-02-05 @修改记录：
	 */
	public static String sendPostRequest(String pushUrl, String data, String encodeCharset, String authorization) {
		String result = "";
		
		HttpClient client = new DefaultHttpClient();
//		client = getHttpClient();
		HttpPost httpPost = new HttpPost(pushUrl);
		HttpResponse response = null;
		
//		String jsonString = "{'pattern': 'name','type': 'fst','files': [{'file_name': 'Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201909270800.json'}]}";

//		System.out.println("json串------" + data);
		try {
			StringEntity entity = new StringEntity(data, encodeCharset);
//			entity.setContentType("application/json");
//			httpPost.setHeader("Authorization", authorization.trim());
//			entity.setContentEncoding("");
			
//			entity.setContentType("application/text");
			httpPost.setHeader("Content-type", "application/text");
			httpPost.setHeader("secretuid", "433f3dd6-d9eb-11e9-9637-00163e30bfa0");
			httpPost.setHeader("secretkey", "YYUTAKPEV6Y4F3P8NQZD3CWF5J");
			
			httpPost.setEntity(entity);
			response = client.execute(httpPost);
			// 获取返回结果
			HttpEntity entry = response.getEntity();
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			result = EntityUtils.toString(entry, encodeCharset);
			System.out.println("返回结果：" + result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			client.getConnectionManager().shutdown();
		}
		return result;
	}
	/**
	 * @功能：设置代理
	 * @param
	 * @return HttpClient
	 * @throws 
	 * 			@日期：2018-02-05 @修改记录：
	 */
	public static HttpClient getHttpClient() {
		DefaultHttpClient httpClient = new DefaultHttpClient();
		// String proxyHost = "Proxy.piccnet.com.cn";
		// int proxyPort = 3128;
		String proxyHost = "10.130.67.170";
		int proxyPort = 10011;
		// String userName = "71012993";
		// String password = "77CD8DE7";
		// httpClient.getCredentialsProvider().setCredentials(new AuthScope(proxyHost,
		// proxyPort),
		// new UsernamePasswordCredentials(userName, password));
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		httpClient.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		return httpClient;
	}
	
	


}
