package com.example.test.producerAndConsumer;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-07  19:38
 */
public class BeanQueue {

    private static PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<Integer>(1000);

    public static PriorityBlockingQueue<Integer> getQueue() {
        return queue;
    }

}
