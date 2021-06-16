package com.example.demo.producerAndConsumer;

import java.util.concurrent.*;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-08  19:07
 */
public class ExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        /*TimeUnit unit = TimeUnit.MILLISECONDS;
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(1024);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 0L, unit, workQueue);
        threadPoolExecutor.execute(new Producer("生产者"));
//        new Producer("生产者").run();
        TimeUnit.MILLISECONDS.sleep(100);
        for (int i = 0; i < 3; i++) {
            threadPoolExecutor.execute(new Consumer("消费者"));
        }
        threadPoolExecutor.shutdown();*/

        Producer producer = new Producer();
//        TimeUnit.MILLISECONDS.sleep(5020);
        Consumer consumer = new Consumer();
        Thread thread = new Thread(consumer);
        Thread thread2 = new Thread(consumer);
        producer.start();
        thread.start();
        thread2.start();
        
        TimeUnit.SECONDS.sleep(5);

        Producer producer2 = new Producer();
        producer2.start();
        
        /*//底层维护了一个平衡二叉树的堆
        //1、添加元素X时，会寻找当前堆中位置的父亲进行比较，如果X小于父亲，那么X将会和父亲的位置进行互换，然后继续与父亲的父亲进行比较，直到X大于其父亲的节点。
        //2、取出元素时，会先把堆顶的数取出返回，然后将堆尾的数X取出重新进行插入，它将会从堆顶开始，X和堆顶节点中两个子节点中较小的一个进行对比，
        //如果比其小，那么X直接成为堆顶；如果比其大，那么较小的子节点成为堆顶。然后X继续和此子节点下的较小子节点进行对比，直到找到X比两个子节点都小的节点，成为其节点
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(1024);
        for (int i = 0; i < 10; i++) {
            queue.put((int) (Math.random() * 100));
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(queue.take());
        }*/
    }
    
}
