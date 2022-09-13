package com.example.test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-08-19  16:07
 */
public class TestDate {

    private static long getInitialDelay(String date) {
        // eg 2:30
        int h = Integer.parseInt(date.split(":")[0]);
        int m = Integer.parseInt(date.split(":")[1]);
        LocalTime startTimeLocal = LocalTime.of(h,m);
        LocalDateTime start = LocalDateTime.of(LocalDate.now(), startTimeLocal);
        System.out.println("before：" + start);
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now：" + now);
        if (start.isBefore(now)) {
            start = start.plusDays(1);
        }
        System.out.println("after：" + start);
        System.out.println(now.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(System.currentTimeMillis());
        long l = start.toInstant(ZoneOffset.of("+8")).toEpochMilli() - System.currentTimeMillis();
        System.out.println(l);

        System.out.println(l / (3600 * 1000));
        return 1L;
    }

    public static String getToken() {
        String appSecret = "YWU2YjFiYTMyYzYyZjRhNmNmMzMyMzNmYzAzMzJhMzIzZjdkZDIxMTZiNDI3N2E2YzU1NGI5N2QwNDQ5ZTQ1Yw==";
        appSecret = new String(Base64.decodeBase64(appSecret), StandardCharsets.UTF_8);

        DateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String gmt = dateFormat.format(new Date());

        return DigestUtils.sha256Hex(appSecret + gmt);
    }

    public static void testLocalDate() {
        String time = "20220506";
        LocalDate date = LocalDate.parse(time, DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDateTime of = LocalDateTime.of(date, LocalTime.MAX);
//        LocalDateTime startTimeDate = LocalDateTime.parse(time, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        System.out.println(of);

    }

    public static void main(String[] args) {
//        TestDate.getInitialDelay("18:37");
//        System.out.println(TestDate.getToken());
        TestDate.testLocalDate();
    }



}
