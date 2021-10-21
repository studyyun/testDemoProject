package com.example.demo.test;

import cn.hutool.core.thread.NamedThreadFactory;
import com.example.demo.service.IStudentService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-30  14:45
 */
@Component
@Slf4j
@EnableScheduling
public class TestScheduled implements CommandLineRunner {

    @Autowired
    private IStudentService studentService;

    private AtomicInteger number = new AtomicInteger();
    
    private static boolean hasDeal;

    @Value("${montnets.dxkf.data.sync.time:7:00}")
    private String time;
    
    private ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, 
                                                    new NamedThreadFactory("业务短信发送线程",false));

    @Override
    public void run(String... args) throws Exception {
        /*log.error("eqweqweqweqweqwe");
        TestThread testThread = new TestThread();
        testThread.run();
        TestThread2 testThread2 = new TestThread2();
        testThread2.run();
        TestThread3 testThread3 = new TestThread3();
        testThread3.run();
//        scheduledThreadPoolExecutor.scheduleWithFixedDelay(testThread,2,5,TimeUnit.SECONDS);
        *//*scheduledThreadPoolExecutor.scheduleAtFixedRate(testThread,2,5,TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(testThread2,2,5,TimeUnit.SECONDS);
        scheduledThreadPoolExecutor.scheduleAtFixedRate(testThread3,2,5,TimeUnit.SECONDS);*//*
        System.out.println(time);*/
    }

    
}

class TestThread extends Thread{
    
    @Override
    public void run() {
        exec();
    }

    private void exec() {
        System.out.println(Thread.currentThread().getName() + "执行啦111：" + new Date());
    }
}

class TestThread2 extends Thread{

    @Override
    public void run() {
        exec();
    }

    private void exec() {
        System.out.println(Thread.currentThread().getName() + "执行啦222：" + new Date());
    }
}

class TestThread3 extends Thread{

    @Override
    public void run() {
        exec();
    }

    private void exec() {
        System.out.println(Thread.currentThread().getName() + "执行啦333：" + new Date());
    }
}

