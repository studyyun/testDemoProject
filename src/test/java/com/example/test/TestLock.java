package com.example.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-05-11  9:59
 */
public class TestLock {

    // @Test
    public void test() throws Exception {
        final Lock lock = new ReentrantLock();
        lock.lock();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " start");
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "异常报错" + e);
                }
                System.out.println(Thread.currentThread().getName() + " end");
                /*System.out.println(Thread.currentThread().getName() + " start");
                lock.lock();
                System.out.println(Thread.currentThread().getName() + " interrupted.");*/
            }
        }, "child thread -1");

        t1.start();
        Thread.sleep(1000);

        t1.interrupt();

        Thread.sleep(1000000);
    }

    public static void main(String[] args) {
        try {
            new TestLock().test();
        } catch (Exception e) {
            System.out.println("中断异常");
        }
    }

}
