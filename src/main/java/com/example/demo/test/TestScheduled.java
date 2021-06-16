package com.example.demo.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-30  14:45
 */
@Component
public class TestScheduled {

    private AtomicInteger number = new AtomicInteger();

    /*@Scheduled(initialDelay = 100, fixedDelayString = "${mailgate.account.cache.time}000")
    public void test() {
        LocalTime start = LocalTime.now();
        //前面和末尾几个字符串是用来改变打印的颜色的
        System.out.println("\033[31;4m" + Thread.currentThread() + " start " + number.incrementAndGet()
                + " @ " + start + "\033[0m");
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(15) * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime end = LocalTime.now();

        System.out.println(Thread.currentThread() + " end " + number.get() + " @ " +
                end + ", seconds cost " + (ChronoUnit.SECONDS.between(start, end)));

    }*/
}
