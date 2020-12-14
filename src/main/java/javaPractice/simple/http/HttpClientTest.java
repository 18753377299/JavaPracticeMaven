package javaPractice.simple.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年6月19日 下午4:06:01
* @version 1.0
* @parameter
* @since
* @return  */
public class HttpClientTest {
public static void main(String []args){
    String url="http://10.10.2.241:5001/?ticket=ST-109bae07-0970-45d1-a2a6-ad4d320de7cd&accountId=5d088e6575abdd6680029b04&callbackUrl=#/login";
    HttpClientTest.httpsGet(url);
}

public static String httpsGet(String url){
CloseableHttpClient httpClient = null;
HttpGet httpGet = null;
String result = "";
try {
httpClient = (CloseableHttpClient) wrapClient();
RequestConfig requestConfig = RequestConfig.custom()
.setSocketTimeout(5000).setConnectTimeout(5000).build();
httpGet = new HttpGet(url);
httpGet.setConfig(requestConfig);
CloseableHttpResponse response = httpClient.execute(httpGet);
HttpEntity httpEntity = response.getEntity();
result = EntityUtils.toString(httpEntity, "utf-8");
} catch (ClientProtocolException e) {
result = "";
} catch (IOException e) {
result = "";
} catch (Exception e) {
result = "";
} finally {
try {
if (httpGet != null) {
httpGet.releaseConnection();
}
if (httpClient != null) {
httpClient.close();
}
} catch (IOException e) {
result = "";
}
}
return result;
}

/**
* @Description 创建一个不进行正式验证的请求客户端对象 不用导入SSL证书
* @return HttpClient
*/
public static HttpClient wrapClient() {
try {
SSLContext ctx = SSLContext.getInstance("TLS");
X509TrustManager tm = new X509TrustManager() {
public X509Certificate[] getAcceptedIssuers() {
return null;
}

public void checkClientTrusted(X509Certificate[] arg0,
String arg1) throws CertificateException {
}

public void checkServerTrusted(X509Certificate[] arg0,
String arg1) throws CertificateException {
}
};
ctx.init(null, new TrustManager[] { tm }, null);
SSLConnectionSocketFactory ssf =
             new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);
CloseableHttpClient httpclient = HttpClients.custom()
.setSSLSocketFactory(ssf).build();
return httpclient;
} catch (Exception e) {
return HttpClients.createDefault();
}
}
}
