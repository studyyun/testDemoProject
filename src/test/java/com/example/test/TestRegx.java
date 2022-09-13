package com.example.test;

import com.example.test.send.DatePatternConstant;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-03-18  11:33
 */
public class TestRegx {

    public static void main(String[] args) {
//        String regex = "[&|\\|]";
        /*String regex = " {2,}";
        Pattern pattern = Pattern.compile(regex);
        System.out.println(pattern.matcher("&").find());
        System.out.println(pattern.matcher("|").find());
        System.out.println(pattern.matcher("||").find());
        System.out.println(pattern.matcher("").find());
        
        String str = " 1 2 3";
        String[] s = str.split(" ");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.find());
        System.out.println(matcher.replaceAll(" "));*/

        LocalDate date = LocalDate.parse("2021-11-20", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime of = LocalDateTime.of(date, LocalTime.MIDNIGHT);
        System.out.println(of);

        System.out.println(date);

        DateTimeFormatter df = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                .parseDefaulting(ChronoField.DAY_OF_MONTH, 1).parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .toFormatter();
        System.out.println(LocalDateTime.parse("2021-11-20", df));
    }
    
}
