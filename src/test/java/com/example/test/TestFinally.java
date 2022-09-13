package com.example.test;

import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-15  10:27
 */
public class TestFinally {

    public static void main(String[] args) {

        try {
            
            int i = 100;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("你好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            test();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("全部结束");
        }


    }

    private static void test() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1111");
    }

}
