package com.example.test;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-30  17:10
 */
public class Test22 {

    public int int1 = 3;

    public final int int2 = 3;

    public static int int3 = 3;

    public static final int int4 = 3;

    private int int5 = 3;

    public static void main(String[] args) {
        /*Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.3.176:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        if (kafkaConsumer instanceof Consumer){
            System.out.println(1111);
        }*/

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        ThreadAAAAA threadAAAAA = new ThreadAAAAA();
        threadAAAAA.start();
        executorService.execute(threadAAAAA);
        executorService.shutdown();
//        executorService.execute(threadAAAAA);

    }

    private void testStringBuilder(StringBuilder stringBuilder) {
        stringBuilder.append("1123123123");
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
