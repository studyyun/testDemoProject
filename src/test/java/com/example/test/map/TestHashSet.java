package com.example.test.map;

import org.roaringbitmap.longlong.Roaring64Bitmap;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-17  11:05
 */
public class TestHashSet {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        HashSet<Long> set = new HashSet<Long>();
        for (int i = 0; i < 600_0000; i++) {
            set.add(13500000000L + i);
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        System.out.println(set.contains(13500000000L));
        System.out.println("结束");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(set.contains(500_0000L));
    }
    
}
