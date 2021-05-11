package javaPractice.reptile;

import io.swagger.annotations.Api;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Api(value = "爬虫Post请求测试")
public class ReptilePostTest {
    public static void main(String[] args) {
        rPostMethod();
    }

    public static void rPostMethod(){
        //创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String  uri = "http://www.itcast.cn/";
        //创建HttpGet请求
        HttpPost httpPost = new HttpPost(uri);

        //声明存放参数的List集合
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("keys", "java"));

        CloseableHttpResponse response = null;
        try {
            //创建表单数据Entity
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params, "UTF-8");

            //设置表单Entity到httpPost请求对象中
            httpPost.setEntity(formEntity);
            //使用HttpClient发起请求
            response = httpClient.execute(httpPost);

            //判断响应状态码是否为200
            if (response.getStatusLine().getStatusCode() == 200) {
                //如果为200表示请求成功，获取返回数据
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                //打印数据长度
                System.out.println(content);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //释放连接
            try {
                if (response != null) {
                        response.close();
                }
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
