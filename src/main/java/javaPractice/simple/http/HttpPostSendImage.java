package javaPractice.simple.http;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class HttpPostSendImage {
	
	public static void main(String []args){
		String url="http://10.156.130.74:30131/zt/c012-0000-gn/00012003/imageQuery";
		String  authorization = "BackType eyJhbGciOiJIUzI1NiJ9.eyJhcHBseU1pY3JvU2VydmljZUNvZGUiOiIwMTAxNDAxMyIsImV4cCI6MTY4MzkwNzIwMDAwMH0.He0U5gCgasoKm1dKYgmhF2btqBxkt3ayz2UCz23uFOE";
		String json = generateImageJson().toString();
		doImageHttpPost(json,url,authorization);
	}
	public static JSONObject generateImageJson() {
		JSONObject audienceAll = new JSONObject();
		try {
			// 推送目标
			JSONObject audienceTwo = new JSONObject();
			audienceTwo.put("appType", "riskControl");
				audienceTwo.put("opId", "A000019300");
				audienceTwo.put("opUser","风控全国");
//				audienceTwo.put("orgNum", userInfo.getComCode());
				audienceTwo.put("orgNum", "00000000");
			audienceAll.put("baseData", audienceTwo);
			//数组
			JSONArray baseform = new JSONArray();
			//数组中对象
			JSONObject baseTwo = new JSONObject();
			baseTwo.put("appCode","riskControl");
			baseTwo.put("busiNum","RCQBA00100002020000002");
			baseform.add(baseTwo);
			audienceAll.put("metaDataList", baseform);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return audienceAll;
	}

	/** 发送Http post请求,对影像系统发送post请求
     * @param xmlInfo   json转化成的字符串
     * @param URL         请求url
     * @return 返回信息
     */
    public static String doImageHttpPost(String xmlInfo, String imageUrl,String authorization) {
        System.out.println("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
        java.io.ByteArrayOutputStream out = null;
        try {
            URL url = new URL(imageUrl);

            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
         // 发送POST请求必须设置如下两行
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            
            urlCon.setUseCaches(false);
            // 测试本地环境post请求
            urlCon.setRequestProperty("Content-type", "application/json");
            urlCon.setRequestProperty("authorization", authorization);
            DataOutputStream printout = new DataOutputStream(urlCon.getOutputStream());
            printout.write(xmlData);
            printout.flush();
            printout.close();
            instr = urlCon.getInputStream();
            byte[] bis = IOUtils.toByteArray(instr);
            String ResponseString = new String(bis, "UTF-8");
            if ((ResponseString == null) || ("".equals(ResponseString.trim()))) {
                System.out.println("返回空");
            }
            System.out.println("返回数据为:" + ResponseString);
            return ResponseString;

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        } finally {
            try {
            	if(out!=null) {
            		out.close();
            	}
                if(instr!=null) {
                	instr.close();
                }
            } catch (Exception ex) {
                return "0";
            }
        }
    }
}
