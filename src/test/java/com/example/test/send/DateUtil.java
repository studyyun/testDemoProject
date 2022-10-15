package com.example.test.send;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;

/**
 *@Author: suw
 *@Date: 2020/5/27 16:26
 *@Description: 日期工具类
 */
public class DateUtil {

    private static final ThreadLocal<SimpleDateFormat> threadLocalSdf = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    /**
     * 设置格式化模式
     * @param pattern
     */
    public static void setSDFPattern(String pattern){
        threadLocalSdf.get().applyPattern(pattern);
    }

    /**
     * 使用默认的pattren格式化日期
     * @param date
     * @return
     */
    public static String sdfFormat(Date date){
        return sdfFormat(date, DatePatternConstant.YYYYMMDDHHMMSS);
    }

    /**
     * 根据指定pattern格式化日期
     * @param date
     * @param pattern
     * @return
     */
    public static String sdfFormat(Date date, String pattern){
        if(StringUtils.isEmpty(pattern) || "null".equals(pattern)){
            throw new IllegalArgumentException("pattern is empty.");
        }
        setSDFPattern(pattern);
        return threadLocalSdf.get().format(date);
    }

    /**
     * 使用默认的pattern格式化日期
     * @param dateStr
     * @return
     */
    public static Date sdfParse(String dateStr){
        return sdfParse(dateStr, DatePatternConstant.YYYYMMDDHHMMSS);
    }

    /**
     * 使用指定pattern格式化日期
     * @param dateStr
     * @param pattern
     * @return
     */
    public static Date sdfParse(String dateStr, String pattern){
        setSDFPattern(pattern);
        Date date = null;
        try {
            date = threadLocalSdf.get().parse(dateStr);
        } catch (ParseException e) {
//            throw new BizRuntimeException("date parse error");
            System.out.println("出错啦");
        }
        return date;
    }


    /**
     * 返回两个日期之间间隔的天数
     */
    public static long between2Days(String date1Str,String date2Str){

        Date date1 = sdfParse(date1Str, DatePatternConstant.YYYYMMDD);
        Date date2 = sdfParse(date2Str, DatePatternConstant.YYYYMMDD);

        long betweenDays = (date2.getTime() - date1.getTime()) / (1000*3600*24);
        return betweenDays;
    }

    //-----------------------------------------------------------------

    /**
     *  Date转换为LocalDateTime
     * @param date
     * @return
     */
    public static LocalDateTime convertDateToLDT(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    /**
     * LocalDateTime转换为Date
     * @param time
     * @return
     */
    public static Date convertLDTToDate(LocalDateTime time) {
        return Date.from(time.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 获取指定日期的毫秒
     * @param time
     * @return
     */
    public static Long getMilliByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    /**
     * 获取指定日期的秒
     * @param time
     * @return
     */
    public static Long getSecondsByTime(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    /**
     * 格式化指定时间
     * @param time
     * @param pattern
     * @return
     */
    public static String formatTime(LocalDateTime time,String pattern) {
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 指定格式转日期
     * @param time
     * @param pattern
     * @return
     */
    public static LocalDateTime parseTime(String time,String pattern) {
        //DateTimeFormatter df=DateTimeFormatter.ofPattern(pattern);
        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern(pattern).parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1).parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .toFormatter();
        return LocalDateTime.parse(time,df);
    }

    /**
     * 格式化当前时间
     * @param pattern
     * @return
     */
    public static String formatNow(String pattern) {
        return  formatTime(LocalDateTime.now(), pattern);
    }

    /**
     * 日期加上一个数,根据field不同加不同值,field为ChronoUnit.*
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime plus(LocalDateTime time, long number, TemporalUnit field) {
        return time.plus(number, field);
    }

    /**
     * 日期减去一个数,根据field不同减不同值,field参数为ChronoUnit.*
     * @param time
     * @param number
     * @param field
     * @return
     */
    public static LocalDateTime minu(LocalDateTime time, long number, TemporalUnit field){
        return time.minus(number,field);
    }

    /**
     * 获取两个日期的差  field参数为ChronoUnit.*
     * @param startTime
     * @param endTime
     * @param field  单位(年月日时分秒)
     * @return
     */
    public static long betweenTwoTime(LocalDateTime startTime, LocalDateTime endTime, ChronoUnit field) {
        Period period = Period.between(LocalDate.from(startTime), LocalDate.from(endTime));
        if (field == ChronoUnit.YEARS) {
            return period.getYears();
        }
        if (field == ChronoUnit.MONTHS) {
            return period.getYears() * 12 + period.getMonths();
        }
        return field.between(startTime, endTime);
    }

    /*public static void main(String[] args) {
        LocalDateTime start = LocalDateTime.of(1993, 10, 13, 11, 11);
        LocalDateTime end = LocalDateTime.of(1994, 11, 13, 13, 13);
        System.out.println("年:" + betweenTwoTime(start, end, ChronoUnit.YEARS));
        System.out.println("月:" + betweenTwoTime(start, end, ChronoUnit.MONTHS));
        System.out.println("日:" + betweenTwoTime(start, end, ChronoUnit.DAYS));
        System.out.println("半日:" + betweenTwoTime(start, end, ChronoUnit.HALF_DAYS));
        System.out.println("小时:" + betweenTwoTime(start, end, ChronoUnit.HOURS));
        System.out.println("分钟:" + betweenTwoTime(start, end, ChronoUnit.MINUTES));
        System.out.println("秒:" + betweenTwoTime(start, end, ChronoUnit.SECONDS));
        System.out.println("毫秒:" + betweenTwoTime(start, end, ChronoUnit.MILLIS));


        LocalDateTime now=LocalDateTime.now();
        LocalDateTime nowTime=DateUtils.plus(now,1, ChronoUnit.DAYS);
        System.out.println(now.toString()+" to ");
        System.out.println(nowTime.toString());
    }*/


}
