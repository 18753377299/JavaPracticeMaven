package javaPractice.simple.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.vo.User;
import io.swagger.annotations.ApiOperation;

public class JsonTransfer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String  json = "{\"userCode\":null,\"passWord\":\"123\",\"age\": 10}";
		User user =  JSON.parseObject(json,User.class);
		System.out.println(user);

		String strOne = JSONObject.toJSONString(generateObject());
		/**{"passWord":"123","age":"10"}*/
		System.out.println(strOne);
		/**QuoteFieldNames———-输出key时是否使用双引号,默认为true
		WriteMapNullValue——–是否输出值为null的字段,默认为false
		WriteNullNumberAsZero—-数值字段如果为null,输出为0,而非null
		WriteNullListAsEmpty—–List字段如果为null,输出为[],而非null
		WriteNullStringAsEmpty—字符类型字段如果为null,输出为”“,而非null
		WriteNullBooleanAsFalse–Boolean字段如果为null,输出为false,而非null*/
		String str = JSONObject.toJSONString(generateObject(), SerializerFeature.WriteMapNullValue);
		/**{"passWord":"123","userCode":null,"age":"10"}*/
		System.out.println(str);
	}

	@ApiOperation(value = "生成jsonObject对象",notes = "addby liqiankun 20201211 beign")
	public static JSONObject generateObject(){
		JSONObject data =new JSONObject();
		data.put("userCode",null);
		data.put("passWord","123");
		data.put("age","10");
		return data;
	}

}
