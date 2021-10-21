package com.example.test;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-10-21  10:50
 */
public class TestThread {
    
    
    
    public static void main(String[] args) throws InterruptedException {

        ThreadAA threadAA = new ThreadAA();
        threadAA.start();

        TimeUnit.SECONDS.sleep(5);
        /*synchronized (TestThread.object) {
            TestThread.object.notify();
        }*/
        
    }
    
}

class ThreadAA extends Thread{

    public static final Object object = new Object();
    
    @Override
    public void run() {
        System.out.println("111");
        try {
            synchronized (ThreadAA.object) {
                ThreadAA.object.wait();
                System.out.println("醒了");
            }
        } catch (InterruptedException e) {
            System.out.println("报错了");
        }
    }

}
