package javaPractice.simple.pattern;

import java.util.regex.Pattern;

public class NumberUtil {
    /**
       * 判断一个字符串是否是数字。
     * 
     * @param string
     * @return
     */
    public static boolean isNumber(String string) {
        if (string == null)
            return false;
//        String regExp = "^[1-9][0-9]*(\\.[0-9]{1,"+2+"})?$";
//        String regExp = "^-?\\d+(\\.\\d+)?$";
//        String regExp = "([1-9]\\d*|0)(\\.\\d{0,0})?";
        /*是否是数字，成功*/
        String regExp = "(^-?[1-9]\\d*|0)(\\.\\d+)?";
        /*从A-E中取一个值*/
//        String regExp = "^[A-E]{1}$";
        
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /*校验一个数字是不是科学计数法的表示*/
    public static boolean isScienceNumber(String string) {
        if (string == null)
            return false;
        /*是否是数字，成功*/
        String regExp = "^[+]?[\\d]+([\\.][\\d]+)?([Ee][+-]?[\\d]+)?$";
        
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /* 是否从给定字符中取值,只取一个*/
    public static boolean isLetter(String string) {
        if (string == null)
            return false;
        /*从A-E中取一个值*/
        String regExp = "^[A-E]{1}|\\s{0}$";
//        String regExp = "^[01,40,99]{2}|\\s{0}$"; //不成功
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /* 是否从给定字符中取值,取一个或多个*/
    public static boolean isLetterMore(String string) {
        if (string == null)
            return false;
        /*从A-E中取一个或多个值进行匹配*/
//        String regExp = "^[A-E]+$";
        String regExp = "^[A-L\\[\\]\"\\,]+$";
        
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /*是否是正数*/
    public static boolean isPostiveInteger(String string) {
        if (string == null)
            return false;
        String regExp = "(^?[1-9]\\d*|0)(\\.\\d+)?";
//        String regExp = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";
        
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /*匹配正整数*/
    public static boolean isZZS(String string) {
        if (string == null)
            return false;
        String regExp = "^[1-9]\\d*|0$";
//        ^[1-9]\d*$　 　 //匹配正整数
//        ^[1-9]\d*|0$ //非负整数（正整数+0）
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    /*邮编校验*/
    public static boolean isPostAddress(String string) {
        if (string == null)
            return false;
        String regExp = "^[1-9]\\d{5}$";
//        ^[1-9]\d*$　 　 //匹配正整数
//        ^[1-9]\d*|0$ //非负整数（正整数+0）
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }
    
    /*邮箱校验*/
    public static boolean isEmail(String string) {
        if (string == null)
            return false;
        String regExp ="\\w+@\\w+(\\.[a-zA-Z]+)+";
//        ^[1-9]\d*$　 　 //匹配正整数
//        ^[1-9]\d*|0$ //非负整数（正整数+0）
        Pattern pattern = Pattern.compile(regExp);
        return pattern.matcher(string).matches();
    }

    
    
    private static void isNumberTest() {
    	System.out.println(isLetter("49"));
//    	System.out.println(isLetterMore("[\"A\",\"Q\",\"C\"]"));
//    	System.out.println(isPostAddress("010010"));
    	
//    	System.out.println(PhoneFormatCheckUtils.isChinaPhoneLegal("13717864823"));
    	System.out.println(isScienceNumber("2222222222222222222222"));
    	
//    	System.out.println(isNumber("D"));
//        System.out.println(isPostiveInteger("123"));
//        System.out.println(isPostiveInteger("-123.456"));
//        System.out.println(isNumber("123成宇佳456"));
//        System.out.println(isNumber("123.456"));
//        System.out.println(isNumber("123.45"));
//        System.out.println(isNumber("0.45"));
//        System.out.println(isNumber("0232.45"));
//        System.out.println(isNumberByte("44010411"));
        
//        System.out.println(isZZS("100"));
        
    }
    public static boolean isNumberByte(String string) {
        if (string == null)
            return false;
//        String regExp = "^[1-9][0-9]*(\\.[0-9]{1,"+2+"})?$";
//        String regExp = "^-?\\d+(\\.\\d+)?$";
//        String regExp = "([1-9]\\d*|0)(\\.\\d{0,0})?";
        String regExp = "^[0-9]{8}";
//        Pattern pattern = Pattern.compile(regExp);
//        return pattern.matcher(string).matches();
        String val = string.toString().trim();
		if(!val.matches(regExp)){
			return false;
		}
		return true;
//        return  string.matches(regExp);
    }

    public static void main(String[] args) {
        isNumberTest();
    }
}