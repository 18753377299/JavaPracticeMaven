package javaPractice.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilePathUtils {
    private static Pattern FilePattern = Pattern.compile("[\\\\/:*?\"<>|]");

    /**
     * 路径遍历 漏洞修复
     * @param str
     * @return
     */
    public static String filenameFilter(String str) {
        return str==null?null:FilePattern.matcher(str).replaceAll("");
    }
    public static String filePathFilter(String data) {
        Pattern pathPattern = Pattern.compile("[\\s\\\\/:\\*\\?\\\"<>\\|]");
        Matcher matcher = pathPattern.matcher(data);
        data = matcher.replaceAll("/");
        System.out.println("{}===>"+data);
        return data;
//        return str==null?null:FilePattern.matcher(data).replaceAll("");
    }

    public static String fileNameValidate(String str) {

        String strInjectListStr ="../|./|/..| |<|>|?";
        if(null!=strInjectListStr && !"".equals(strInjectListStr))
        {
            str = str.toLowerCase();
            String[] badStrs = strInjectListStr.split("\\|");
            for (int i = 0; i < badStrs.length; i++) {
                if (str.indexOf(badStrs[i]) >= 0) {
                    str= str.replace(badStrs[i], "");
                }
            }
        }
        return str;
    }

    public static boolean isAbsolutePath(String path){
//        boolean flag = true;
        String fileNameListStr ="../|./|/..";
        if(StringUtils.isBlank(path)){
            return false;
        }
        String[] badStrs = fileNameListStr.split("\\|");
        for (String str :badStrs){
            if(path.indexOf(str)!=-1){
                return false;
            }
        }
        return true;
    }

}
