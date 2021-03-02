package javaPractice.simple.json;


import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;

import java.text.SimpleDateFormat;

@Api(value="使用fastJson进行日期格式转换")
public class JsonDate {
    public static void main(String []args){
        String source  ="{\"startDate\": \"4739-12-21T16:00:00.000Z\"}";
        RequestBean bean = JSON.parseObject(source,RequestBean.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDate = sdf.format(bean.getStartDate());
        System.out.println(startDate);
    }

}
