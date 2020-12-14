package com.common.utils;

import java.text.NumberFormat;

/*进行数字类型的操作，addby liqiankun  20201214 begin*/
public class NumberUtils {
    /**
     * 获取自增数据 如001，002，003
     * */
    public static String getIncreaseNumber( int num) {
        Integer number = num ;
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        /*它设置数字的整数部分中允许的最小位数*/
        numberFormat.setMinimumIntegerDigits(3);
        /*设为false则不使用分组方式显示数据，例：9999999 ，
        * 设为true，例： 打印出 9,999,999
        * */
        numberFormat.setGroupingUsed(false);
        String s = numberFormat.format(number);
        return s;
    }


}
