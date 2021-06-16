package com.example.demo.producerAndConsumer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-07  19:36
 */
public class Producer extends Thread {

    private AtomicInteger integer = new AtomicInteger(0);

    public Producer() {
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            /*synchronized (EnumLock.INSTANCE) {
                System.out.println(Thread.currentThread().getName() + "生产者抢到锁啦");
                try {
                    EnumLock.INSTANCE.notifyAll();
                    BeanQueue.getQueue().add(integer.incrementAndGet());
                    System.out.println(Thread.currentThread().getName() + "生产：" + integer);
                    TimeUnit.MILLISECONDS.sleep(20);
//                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "生产者释放锁啦");
                    EnumLock.INSTANCE.wait();
//                    TimeUnit.SECONDS.sleep(1);
                } catch (Exception e) {
                    System.out.println(Thread.currentThread().getName() + "生产者报错了" + e);
                }
            }*/
            
            try {
                BeanQueue.getQueue().put(integer.incrementAndGet());
                System.out.println(Thread.currentThread().getName() + "生产：" + integer);
            } catch (Exception e) {
                System.out.println(Thread.currentThread().getName() + "生产者报错了" + e);
            }

        }

        System.out.println("生产者结束");

    }


}
