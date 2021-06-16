package com.example.demo;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-25  16:53
 */
public class TestThreadLocal {

    private static ThreadLocal<String> threadLocal;

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 0,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(1024),
            Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());

    public void test() {
        String hello = "nihao";
        threadLocal = new InheritableThreadLocal<>();
        threadLocal.set(hello);
    }

    public void test2() {
        ThreadLocal<String> threadLocal2;
        String hello = "nihao";
        threadLocal2 = new ThreadLocal<>();
        threadLocal2.set(hello);
        //此时因为threadLocal2对象还存在强引用，所以GC回收不了
        System.gc();
        System.out.println(threadLocal2.get());
        //最好在使用完之后进行remove操作，防止内存泄露。
        //这种局部变量使用threadLocal的场景可以使用在：比如存储请求上下文，当这个请求结束之后，这个请求上下文也可以跟着被回收了
        //当然，平时主要还是用一个全局变量声明threadLocal，这样一直会持有强引用，也不会存在内存泄露的问题了
        threadLocal2.remove();
    }


    public static void main(String[] args) throws InterruptedException {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.test2();
        //此时进行GC回收，因为test2已经执行完毕，而Entry散列数组里面是以弱引用的形式存储threadLocal2对象
        //当不存在别的强引用(此时只有自身的引用)，触发GC就会被回收掉。但是如果当前线程对象一直不结束，那么存储threadLocal对象的threadLocalMap一直不会回收，
        //threadLocalMap的散列数组Entry数组就会一直持有value的强引用，导致value回收不了，造成内存的泄露。
        System.gc();
        ThreadLocal<String> threadLocal3 = new ThreadLocal<>();
        //可在此时查看threadLocalMap中存储的值，发现之前的(threadLocal2,value)变成了(null,value)
        threadLocal3.set("wo bu hao");
        System.out.println(threadLocal3.get());
        threadLocal3.remove();
        /*testThreadLocal.test();

        System.gc();
        TimeUnit.SECONDS.sleep(1);

        for (int i = 0; i < 5; i++) {
            int num = i;
            executor.execute(() -> {
                System.out.println(Thread.currentThread() + "----" + threadLocal.get());
                if (num == 1) {
                    threadLocal.set("i am not ok");
                }
                System.out.println(Thread.currentThread() + "----" + threadLocal.get());

            });
        }

        System.gc();
        TimeUnit.SECONDS.sleep(2);
        System.out.println(Thread.currentThread() + "----" + threadLocal.get());
        executor.shutdown();*/
    }

}
