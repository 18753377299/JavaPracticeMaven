package javaPractice.simple.http;

import com.common.response.AjaxResult;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.DataOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
	/**
 * @author  作者 E-mail: 
 * @date 创建时间：2019年9月19日 下午3:11:41
 * @version 1.0 
 * @parameter 获取气象局栅格数据,success
 * @since  
 * @return  */
public class HttpPostSend {

	/**
	 * @功能：获取气象局栅格数据,success: 看看是不是因为内网的原因，家中的网络能够成功的调用这个接口，
	 * 并能够获取到信息，数据格式和之前商定的不太统一，需要确认一下
	 * @param 
	 * @return void
	 * @author liqiankun
	 * @时间：20190919
	 * @修改记录：
	 */	
	public static  void main(String[]args) {
		AjaxResult ajaxResult =new AjaxResult();
//		String url = "http://60.205.166.252/renbaofile/FileProvider/downloadFileByJson";
//		String param = "secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=YYUTAKPEV6Y4F3P8NQZD3CWF5J&Content-type=application/text";
//		String responseJson =this.doGet(url, param);
		
		String url = "http://60.205.166.252/renbaofile/FileProvider/downloadFileByJson?secretuid=433f3dd6-d9eb-11e9-9637-00163e30bfa0&secretkey=YYUTAKPEV6Y4F3P8NQZD3CWF5J&Content-type=application/text";
		/*json文件能够成功*/
//		String jsonString = "{'pattern': 'name','type': 'fst','files': [{'file_name': 'Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201910112000.json'}]}";
		/*asc文件，也能够成功，需要将asc文件内容直接输出到一个asc文件中，获取直接生成栅格数据*/
//		String jsonString = "{'pattern': 'name','type': 'fst','files': [{'file_name': 'Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201910110800.asc'}]}";
		
		String jsonString = generateJson().toString();
		String responseJson =doHttpPost(jsonString, url);
		System.out.println("success");
		
	}
	/**
	 * @功能：组织调用气象局接口数据参数的组织
	 * @param 
	 * @return void
	 * @author liqiankun
	 * @时间：20190930
	 * @修改记录：
	 */	
	public static JSONObject generateJson() {
		// 推送目标
		JSONObject audience = new JSONObject();
		audience.put("pattern", "name");
//		audience.put("type", "fst");
		audience.put("type", "obs");
		//数组
		JSONArray platform = new JSONArray();
		//数组中对象
		JSONObject message = new JSONObject();
//		message.put("file_name", "Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201911200800.json");
//		message.put("file_name", "Z_NWGD_C_BABJ_P_RFFC_SCMOC-ER24_201911210800.asc");
		//实况雨场数据请求
		message.put("file_name", "Z_SURF_C_BABJ_P_CMPA_FAST_CHN_0P05_DAY-PRE-2020040808.json");
		
		platform.add(message);
		// 将数组添加到大对象中
		audience.put("files", platform);
		return audience;
	}
	
	/**
     * 发送Http post请求
     * 
     * @param xmlInfo
     *            json转化成的字符串
     * @param URL
     *            请求url
     * @return 返回信息
     */
    public static String doHttpPost(String xmlInfo, String URL) {
        System.out.println("发起的数据:" + xmlInfo);
        byte[] xmlData = xmlInfo.getBytes();
        InputStream instr = null;
        java.io.ByteArrayOutputStream out = null;
        String jwtToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJ1c2VyTmFtZVwiOlwi6aOO5o6n5YWo5Zu9XCIsXCJyaXNrQ29kZVwiOm51bGwsXCJjb21Db2RlXCI6XCIwMDAwMDAwMFwiLFwidXNlckNvZGVcIjpcIkEwMDAwMTE1MzNcIixcInJpc2tDb21Db2RlXCI6bnVsbCxcImNsYXNzQ29kZVwiOm51bGwsXCJlbWFpbFwiOm51bGwsXCJ2ZXJzaW9uXCI6XCJ2MS4wLjEuMFwiLFwiY29tQ05hbWVcIjpcIuaAu-WFrOWPuFwiLFwic2Vzc2lvbklEXCI6bnVsbCxcImxvZ2luQ29tQ29kZVwiOm51bGwsXCJncm91cFVzZXJDb2RlXCI6bnVsbCxcInRhc2tDb2RlTGlzdFwiOltcInJpc2tjb250cm9sXCIsXCJyaXNraW5zXCIsXCJyaXNraW5zXCIsXCJyaXNrc2FsZVwiLFwicmlza3NldFwiLFwicmlza2luc19pbnB1dFwiLFwicmlza2luc19xdWVyeVwiLFwicmlza2luc19xdWVyeVwiLFwicmlza3NhbGVfZXhhbWluZVwiLFwicmlza3NhbGVfY29sbGVjdFwiLFwicmlza3NldF9jbGVhckNhY2hlXCIsXCJyaXNrc2V0X3Jpc2tEbmF0dXJhbFwiLFwicmlza3NldF9yaXNrRG5hdHVyYWxcIixcInJpc2tJbmZvXCIsXCJyaXNraW5zX3NldFwiLFwicmlza2luc191bmRcIixcInJpc2tpbnNleHBfc2V0XCIsXCJyaXNraW5zX3VuZGZpclwiLFwicmlza2luc191bmRzZWNcIixcInJpc2tjaGVja19pbnB1dEFuZFF1ZXJ5XCIsXCJyaXNrY2hlY2tfZGlzdHJpYnV0ZVwiLFwicmlza2luc19zY29yZVwiXSxcInBvc3RMaXN0XCI6W1wicmlza2luc191bmRzZWMt6aOO5o6n5oql5ZGK5LqM57qn5a6h5qC45bKXXCIsXCJyaXNraW5zX3NldC3po47mjqfkv6Hmga_nu7TmiqTlspdcIixcInJpc2tpbnNfdW5kZmlyLemjjuaOp-aKpeWRiuS4gOe6p-WuoeaguOWyl1wiLFwicmlza2luc19pbnB1dC3po47mjqfmiqXlkYrlvZXlhaXlspdcIixcInJpc2tpbnMt6aOO5o6n57uT5p6c5p-l6K-i5bKXXCIsXCJyaXNraW5zZXhwX3NldC3po47mjqfkuJPlrrbnu7TmiqTlspdcIixcInJpc2tjaGVja19pbnB1dEFuZFF1ZXJ5LemjjuaOp-W3oeajgOWyl1wiLFwicmlza3NhbGVfY29sbGVjdC3nhafniYfmoaPmoYjph4fpm4blspdcIixcInJpc2tpbnNfdW5kLemjjuaOp-S_oeaBr-WuoeaguOWyl1wiLFwicmlza3NldC3po47mjqfnrqHnkIblspdcIixcInJpc2tjaGVja19kaXN0cmlidXRlLemjjuaOp-W3oeajgOa0vuWPkeWyl1wiLFwicmlza2luc19xdWVyeS3po47mjqfmiqXlkYrmn6Xor6LlspdcIixcInJpc2tzYWxlX2V4YW1pbmUt54Wn54mH5qGj5qGI5a6h5qC45bKXXCIsXCJyaXNraW5mby3po47mjqfkv6Hmga_lspdcIl0sXCJpc1BDXCI6dHJ1ZSxcImlzT3V0ZXJTeXN0ZW1cIjpmYWxzZX0iLCJleHAiOjE1NjkwMjQ3MjB9.Bv9-bblmn4tRe96lkAMgF8MLk3wBjARleueYZwO18XD70gegAbhC_blcwoW2s-UB8P-zO8M7tFzSBkj_IwCl6g";
        try {
            URL url = new URL(URL);
            //设置代理，（试验成功）
//            Proxy proxy = new Proxy(Proxy.Type.HTTP,new InetSocketAddress("Proxy.piccnet.com.cn",3128));
//            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection(proxy);

//            URLConnection urlCon = url.openConnection();
            HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
         // 发送POST请求必须设置如下两行
            urlCon.setDoOutput(true);
            urlCon.setDoInput(true);
            
            urlCon.setUseCaches(false);
            // 测试本地环境post请求
//            urlCon.setRequestProperty("Content-type", "application/json");
//            urlCon.setRequestProperty("jwtToken", jwtToken);
            
            urlCon.setRequestProperty("Content-type", "application/text");
            urlCon.setRequestProperty("secretuid", "433f3dd6-d9eb-11e9-9637-00163e30bfa0");
            urlCon.setRequestProperty("secretkey", "YYUTAKPEV6Y4F3P8NQZD3CWF5J");
//            urlCon.setRequestProperty("charset", "utf-8");
//            urlCon.setRequestProperty("Content-length",String.valueOf(xmlData.length));
//            System.out.println(String.valueOf(xmlData.length));
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
                out.close();
                instr.close();

            } catch (Exception ex) {
                return "0";
            }
        }
    }
	
}
