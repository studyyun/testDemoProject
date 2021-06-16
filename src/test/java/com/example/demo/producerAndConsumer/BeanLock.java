package com.example.demo.producerAndConsumer;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-07  19:36
 */
public class BeanLock {
    
    private static volatile BeanLock lock;

    public static BeanLock getSingletonInstance(){
        if (lock == null){
            synchronized (BeanLock.class){
                if (lock == null){
                    lock = new BeanLock();
                }
            }
        }
        return lock;
    }


    public static void main(String[] args) {
        /*BeanLock instance = BeanLock.getSingletonInstance();
        System.out.println(instance);*/

        System.out.println(BeanLock.lock);
    }
}
