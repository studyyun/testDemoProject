package com.example.demo.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-11-05  11:04
 */

@Configuration
@EnableScheduling
public class Scheduling implements SchedulingConfigurer {
    
    //每5分钟执行一次
    private String cron = "0 30 * * * ?";

    //设置线程名称
    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
    //创建线程池
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5, namedThreadFactory);


    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        ThreadAAAAA threadAAAAA = new ThreadAAAAA();
        threadAAAAA.start();
        /*scheduledExecutorService.execute(()->{
            System.out.println("定时器执行啦1111！！！" + new Date() + Thread.currentThread().getName());
        });
        taskRegistrar.setScheduler(scheduledExecutorService);*/
        taskRegistrar.addTriggerTask(threadAAAAA, triggerContext -> new CronTrigger(cron).nextExecutionTime(triggerContext));
        List<TriggerTask> triggerTaskList = taskRegistrar.getTriggerTaskList();
        int i = 0;
    }
}


class ThreadAAAAA extends Thread {


    private volatile boolean isExecuted = false;

    public ThreadAAAAA() {
    }

    @Override
    public void run() {
        try {
            if (isExecuted) {
                System.out.println("正在执行");
                return;
            }
            isExecuted = true;
            System.out.println(Thread.currentThread().getName() + new Date());
            TimeUnit.SECONDS.sleep(10);
        } catch (Exception e) {
            System.out.println("错误");
        } finally {
            isExecuted = false;
        }
    }

} 
