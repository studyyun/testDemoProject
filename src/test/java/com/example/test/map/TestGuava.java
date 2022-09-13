package com.example.test.map;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-01  17:06
 */
public class TestGuava {

    public static void main(String[] args) {
        Cache<Long, Long> cache = CacheBuilder.newBuilder().build();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 600_0000; i++) {
            cache.put(13500000000L + i, 13500000000L + i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(cache.size());
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
