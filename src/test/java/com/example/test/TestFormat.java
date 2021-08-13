package com.example.test;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-04-25  17:33
 */
public class TestFormat {

    public static void main(String[] args) throws InterruptedException {
        final DecimalFormat format = new DecimalFormat("0.00%");
        List<Long> lists = new ArrayList<Long>() {
            {
                add(1L);
                add(2L);
                add(3L);
                add(4L);
                add(5L);
                add(6L);
            }
        };
        ExecutorService executorService = Executors.newCachedThreadPool();
        //用CountDownLatch增加并发度
        CountDownLatch countDownLatch = new CountDownLatch(lists.size());
        for (Long list : lists) {
            executorService.submit(() -> {
                try {
                    countDownLatch.await();
                    String parse = format.format((double)list / 7L);
                    System.out.println(parse);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            TimeUnit.SECONDS.sleep(1);
            countDownLatch.countDown();
        }
        System.out.println("main");
        executorService.shutdown();
    }
    
}
