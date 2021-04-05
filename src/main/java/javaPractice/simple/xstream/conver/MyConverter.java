package javaPractice.simple.xstream.conver;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import io.swagger.annotations.Api;


@Api(value="xStream中的自定义转换器(Converter)")
public class MyConverter implements SingleValueConverter {

     public String toString(Object var1){
         if(null == var1){
             return null;
         }
         return var1.toString();
    }

    public Object fromString(String var1){
        if(null == var1){
            return null;
        }
        return var1;
    }
    /*.其中canConvert()用来判断需要序列化的对象是否使用此转换器，
    用户可以在此方法自定义使用的类，或者可以直接返回true来表名此转换器为通用。
    xstream会自动执行此方法，如果canConvert()的返回结果为false，转换器将不起作用*/
    public boolean canConvert(Class var1){
         return false;
    }


}
