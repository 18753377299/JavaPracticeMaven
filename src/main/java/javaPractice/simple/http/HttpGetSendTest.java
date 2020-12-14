package javaPractice.simple.http;

import com.common.response.AjaxResult;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.SimpleHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpHost;
import org.apache.http.conn.params.ConnRouteParams;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年9月19日 下午3:11:41
 * @version 1.0 
 * @parameter 
 * @since  
 * @return  */
public class HttpGetSendTest {
	
	/**
	 * @功能：获取气象局栅格数据
	 * @param 
	 * @return void
	 * @author liqiankun
	 * @时间：20190924
	 * @修改记录：
	 */	
	@SuppressWarnings("unused")
	public static  void main(String[]args) {
		AjaxResult ajaxResult =new AjaxResult();
		String url = "http://60.205.166.252/renbaofile/FileProvider/downloadFileByJson";
		String param = "secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=YYUTAKPEV6Y4F3P8NQZD3CWF5J&Content-type=application/text";
		/*能够成功调用到json信息，家中的电脑*/
		String responseJson =doGet(url, param);
		System.out.println(responseJson);
	}
	
	/**
     * 执行一个带参数的HTTP GET请求，返回请求响应的JSON字符串
     *
     * @param url 请求的URL地址
     * @return 返回请求响应的JSON字符串
     */
    public static String doGet(String url, String param) {
        HttpClient client = new HttpClient(new HttpClientParams(),new SimpleHttpConnectionManager(true));
//        GetMethod method = new GetMethod(url + "?" + param);
        String urlstr = "http://60.205.166.252/typhoon/getTyphoonFstNew?startTime=20190210000000&endTime=20190720000000&secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=U7WJVZDK8PDNM9W1APFTFMJ1DK";
        GetMethod method = new GetMethod(urlstr);
        
        HttpHost proxy = new HttpHost("Proxy.piccnet.com.cn", 3128);
        method.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                return StreamUtils.copyToString(method.getResponseBodyAsStream(), Charset.forName("utf-8"));
            }
        } catch (IOException e) {
        	e.printStackTrace();
//        	LOGGER.info("执行HTTP Get请求" + url + "时，发生异常！",e);
        	throw new RuntimeException("执行HTTP Get请求" + url + "时，发生异常！",e);
        } finally {
            method.releaseConnection();
        }
        return "";
    }
    /**
	 * @功能：设置代理
	 * @param
	 * @return HttpClient
	 * @throws 
	 * 			@日期：2018-02-05 @修改记录：
	 */
	public static GetMethod getHttpClient(GetMethod method) {
//		DefaultHttpClient httpClient = new DefaultHttpClient();
		 String proxyHost = "Proxy.piccnet.com.cn";
		 int proxyPort = 3128;
//		String proxyHost = "10.130.67.170";
//		int proxyPort = 10011;
//		 String userName = "71012993";
//		 String password = "77CD8DE7";
//		 method.getCredentialsProvider().setCredentials(new AuthScope(proxyHost,
//		 proxyPort),new UsernamePasswordCredentials(userName, password));
		HttpHost proxy = new HttpHost(proxyHost, proxyPort);
		method.getParams().setParameter(ConnRouteParams.DEFAULT_PROXY, proxy);
		return method;
	}
}
