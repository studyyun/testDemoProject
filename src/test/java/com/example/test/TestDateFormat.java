package com.example.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-04-25  17:37
 */
public class TestDateFormat {

    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<String> lists = new ArrayList<String>() {
            {
                add("2018-11-22 01:11:11");
                add("2018-11-22 02:22:22");
                add("2018-11-22 03:33:33");
                add("2018-11-22 04:44:44");
                add("2018-11-22 03:55:55");
                add("2018-11-22 04:55:56");
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        //用CountDownLatch增加并发度
        CountDownLatch countDownLatch = new CountDownLatch(lists.size());
        for (String list : lists) {
            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    Date parse = format.parse(list);
                    System.out.println(parse.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            countDownLatch.countDown();
        }
    }
    
}
