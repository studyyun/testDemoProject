package com.example.test;

import cn.hutool.core.thread.NamedThreadFactory;

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-08-18  15:54
 */
public class TestThreadPool {

    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(8, 10, 1, TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(1024), new NamedThreadFactory("hello", false), new ThreadPoolExecutor.AbortPolicy());

    private boolean ifOk = false;

    private void test() {
        if (!ifOk) {
            ifOk = true;
            System.out.println("i am ok " + Thread.currentThread().getName() + "  " + System.currentTimeMillis());
        }
        System.out.println(Thread.currentThread().getName() + "  " + System.currentTimeMillis());
    }

    public static void main(String[] args) {
        TestThreadPool bean = new TestThreadPool();
        for (int i = 0; i < 100; i++) {
            TestThreadPool.poolExecutor.execute(bean::test);
        }
        TestThreadPool.poolExecutor.shutdown();
    }

}
