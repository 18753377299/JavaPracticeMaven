package javaPractice.simple.json;

import com.common.utils.JsonUtils;

public class JsonTest {
    public static void main(String []args){
        String  json = "{\"userCode\":null,\"passWord\":\"123\",\"age\": 10}";
      String result  = JsonUtils.formatJSON(json);
      System.out.println(result);


    }
}
