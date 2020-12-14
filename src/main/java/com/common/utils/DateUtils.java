package com.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
* @author  作者 E-mail:
* @date 创建时间：2019年10月22日 下午5:33:59
* @version 1.0
* @parameter 	 SimpleDateFormat并非是线程安全的， 每一个使用SimpleDateFormat对象进行日期-时间进行format和
*	 parse方法的时候就创建一个新的SimpleDateFormat对象，用完就销毁即可！
* @since  日期类型的工具
* @return  */
public class DateUtils {
/**
 * 获得某个月最大天数,传递参数是日期类型的字符串
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public  static int getMaxDayByYearMonth(String yearMonth){
    SimpleDateFormat  sdf_YM = new SimpleDateFormat("yyyy-MM");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YM.parse(yearMonth));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return calendar.getActualMaximum(Calendar.DATE);
}
/**
 * 获得某个月最大天数
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public  static int getMaxDayByYearMonth(int year,int month){
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month);
    return calendar.getActualMaximum(Calendar.DATE);
}
/**
 * 将日期格式转换为字符串类型,年月日类型yyyy-MM-dd
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public static String dateTransferStrYMD(Date date){
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    return  sdf_YMD.format(date);
}
/**
 * 将yyyy-MM-dd HH:mm:ss格式转换yyyy-MM-dd
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public static String strTransferStrYMD(String date){
    // yyyy-MM-dd HH:mm:ss 必须要写成这样，如果写成YYYY-MM-dd HH:mm:ss 会出会出现日期时间错误，跟原有时间不一致。
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_HMS.parse(date));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return  sdf_YMD.format(calendar.getTime());
}
/**
 * 将日期格式转换为字符串类型,年月日类型YYYY-MM-dd HH:mm:ss
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public static String dateTransferStrHMS(Date date){
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return  sdf_HMS.format(date);
}
/**
 * 将字符串类型转换为日期类型,年月日类型YYYY-MM-dd HH:mm:ss
 * @param year 年份
 * @param month 月份 (1-12)
 * @return 某个月最大天数
 */
public static Date strHMSTransferDate(String  date){
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date returnDate = null;
    try {
        returnDate = sdf_HMS.parse(date);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return  returnDate;
}
/**
 * 获取某一日期的下一天的日期
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getNextDate(Date date){
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    return  sdf_YMD.format(calendar.getTime());
}
/**
 * 获取当前日期是周几
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getWeekOfDate(String dayOfYear){
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    String [] weekDays ={"7","1","2","3","4","5","6"};
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YMD.parse(dayOfYear));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    int week = calendar.get(Calendar.DAY_OF_WEEK)-1;
    if(week<0){
        week = 0;
    }
    return  weekDays[week];
}

/**
 * 获取的一天的开始时间
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getStartDateOfDay(Date date){
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YMD.parse(sdf_YMD.format(date)));
    } catch (ParseException e) {
        e.printStackTrace();
    }
//		calendar.setTime(date);
//		// 如果值传递年月日的话，可以把下面这一段去掉
//		calendar.set(Calendar.HOUR_OF_DAY, 0);
//		calendar.set(Calendar.MINUTE, 0);
//		calendar.set(Calendar.SECOND, 0);
//		calendar.set(Calendar.MILLISECOND, 0);
//		System.out.println(calendar.getTimeInMillis());

    /**  other way
    SimpleDateFormat formater = new SimpleDateFormat("yyyy/MM/dd");
    SimpleDateFormat formater2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    start = formater2.parse(formater.format(new Date())+ " 00:00:00");
    end = formater2.parse(formater.format(new Date())+ " 23:59:59");*/

    return sdf_HMS.format(calendar.getTime());
}
/**
 * 获取的一天的结束时间
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getEndDateOfDay(Date date){
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
//		calendar.set(Calendar.HOUR_OF_DAY,23);
//		calendar.set(Calendar.MINUTE, 59);
//		calendar.set(Calendar.SECOND, 59);
//		calendar.set(Calendar.MILLISECOND, 999);
    // 获取到第二天减一秒
    calendar.add(Calendar.DAY_OF_MONTH, 1);
    calendar.add(Calendar.SECOND, -1);
//		System.out.println(calendar.getTimeInMillis());
    return sdf_HMS.format(calendar.getTime());
}
/**
 * 获取的一个月的开始时间
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getStartDateOfMonth(String date){
    SimpleDateFormat  sdf_YM = new SimpleDateFormat("yyyy-MM");
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YM.parse(date));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return sdf_HMS.format(calendar.getTime());
}
/**
 * 获取的一个月的结束时间
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static String getEndDateOfMonth(String date){
    SimpleDateFormat  sdf_HMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat  sdf_YM = new SimpleDateFormat("yyyy-MM");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YM.parse(date));
        // 获取到第二天减一秒
        calendar.add(Calendar.MONTH, 1);
        calendar.add(Calendar.SECOND, -1);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return sdf_HMS.format(calendar.getTime());
}
/**
 * 获取当天十一点半的时间
 * @param year 年份
 * @param month 月份 (1-12)
 * @return
 */
public static Date getHalfDateOfDay(String date){
    SimpleDateFormat  sdf_YMD = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance();
    try {
        calendar.setTime(sdf_YMD.parse(date));
        calendar.set(Calendar.HOUR_OF_DAY,11);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return calendar.getTime();
}

}
