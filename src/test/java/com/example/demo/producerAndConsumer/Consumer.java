package com.example.demo.producerAndConsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-07  19:36
 */
public class Consumer implements Runnable {
    
    private static final AtomicInteger COUNT = new AtomicInteger(0);
    
    public Consumer() {
    }

    @Override
    public void run() {
//        for (int i = 0; i < 100; i++) {
        while (true) {
            /*try {
                synchronized (EnumLock.INSTANCE) {

                    TimeUnit.MILLISECONDS.sleep(20);
                    System.out.println(Thread.currentThread().getName() + "消费者抢到锁啦");
                    Integer integer = BeanQueue.getQueue().poll();
                    while (integer != null) {
                        COUNT.decrementAndGet();
                        System.out.println(Thread.currentThread().getName() + "消费：" + integer);
                        TimeUnit.MILLISECONDS.sleep(20);
                        EnumLock.INSTANCE.notifyAll();
                        System.out.println(Thread.currentThread().getName() + "消费者释放锁啦");
                        EnumLock.INSTANCE.wait();
                        System.out.println(Thread.currentThread().getName() + "消费者抢到锁啦");
                        integer = BeanQueue.getQueue().poll();
                        //                      TimeUnit.SECONDS.sleep(1);
                    }
                    TimeUnit.MILLISECONDS.sleep(20);
                    if (COUNT.incrementAndGet() >= 15){
                        System.out.println("没有任务需要消费，进入wait休眠状态");
                        EnumLock.INSTANCE.wait();
                    }
                    EnumLock.INSTANCE.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "消费者释放锁啦");
                    EnumLock.INSTANCE.wait();
                    
                }

                
//            EnumLock.INSTANCE.wait();    
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "消费者报错了：" + e);
            }*/

            try {
                System.out.println(Thread.currentThread().getName() + "消费：" + BeanQueue.getQueue().take());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "消费者报错了" + e);
            }
            COUNT.incrementAndGet();
            System.out.println("第" + COUNT.get() + "次消费");
        }


//        }

    }
}
