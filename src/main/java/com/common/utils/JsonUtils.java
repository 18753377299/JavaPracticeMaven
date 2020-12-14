package com.common.utils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.apache.commons.lang3.StringUtils;

public class JsonUtils {

    /**
     * json 格式化
     * @author 赵天园
     * @Date 2019年8月2日
     */
    public static String formatJSON( String json) {
        String res = "";
        if(StringUtils.isNotBlank(json) ) {
            /*使用 new GsonBuilder.setPrettyPrinting().create()方法创建的Gson对象
        来生成的JSON数据就是格式化的数据，上面的转换代码只是针对原料是JSON String的情况*/
            res = new GsonBuilder().setPrettyPrinting()
                    .disableHtmlEscaping()
                    .create().toJson( new JsonParser().parse(json) );
        }
        return res;
    }
}
