package javaPractice.reptile;

import io.swagger.annotations.Api;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

@Api(value = "爬虫Get请求测试")
public class ReptileGetTest {

    public static void main(String[] args) {
        reptileMethod();
    }
    public static  void reptileMethod() {
        CloseableHttpResponse response = null;
        CloseableHttpClient httpClient = null;
        try {
            httpClient = HttpClients.createDefault();
//            String uri = "http://www.itcast.cn/";
            String uri = "http://yun.itheima.com/search?keys=Java";
            HttpGet httpGet = new HttpGet(uri);
//            HttpGet httpGet = new HttpGet("https://www.baidu.com/");

            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }finally {
            try {
                if(null!=response){
                   response.close();
                }
                if(null!=httpClient){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
