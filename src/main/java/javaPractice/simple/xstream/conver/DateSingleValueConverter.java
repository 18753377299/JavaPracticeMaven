package javaPractice.simple.xstream.conver;

import com.thoughtworks.xstream.converters.SingleValueConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSingleValueConverter implements SingleValueConverter {
    private SimpleDateFormat dsf0  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private   SimpleDateFormat dsf1 = new SimpleDateFormat("yyyy-MM");
    private   SimpleDateFormat dsf2 = new SimpleDateFormat("yyyy-MM-dd");


    public String toString(Object var1){
        if(null == var1 || "".equals(var1)){
            return null;
        }


        return var1.toString();
    }

    public Object fromString(String var1){
        String str = var1;
        if(null == var1 || "".equals(var1)){
            return null;
        }
        Date result = null;
        try {
            if(str.length()<=10){
                if(str.length() == 7){
                    result = dsf1.parse(str);
                }else {
                    result = dsf2.parse(str);
                }
            }else {
                result = dsf0.parse(str);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public boolean canConvert(Class var1){
        return false;
    }


}
