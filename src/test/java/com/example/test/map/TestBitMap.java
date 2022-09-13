package com.example.test.map;

import org.roaringbitmap.insights.BitmapAnalyser;
import org.roaringbitmap.longlong.Roaring64Bitmap;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-15  15:08
 */
public class TestBitMap {

    public static void main(String[] args) {
        /*Roaring64Bitmap bitmap1 = new Roaring64Bitmap();
        Roaring64Bitmap bitmap2 = new Roaring64Bitmap();
        int k = 1 << 16;
        long i = Long.MAX_VALUE / 2;
        long base = i;
        for (; i < base + 10000; ++i) {
            bitmap1.add(i * k);
            bitmap2.add(i * k);
        }
        bitmap1.and(bitmap2);
        bitmap1.toString()*/
        
//        test1111();
        test2222();
    }

    private static void test2222() {
        long start = System.currentTimeMillis();
        Roaring64Bitmap roaring64Bitmap = new Roaring64Bitmap();
        for (int i = 0; i < 600_0000; i++) {
            roaring64Bitmap.add(13500000000L + i);
            if (i == 500_0000) {
                roaring64Bitmap.add(13500000000L);
                roaring64Bitmap.add(13500000000L);
                roaring64Bitmap.add(13500000000L);
                roaring64Bitmap.add(13500000000L);
            }
        }
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(roaring64Bitmap.contains(13500000000L));
        System.out.println(roaring64Bitmap.getLongCardinality());
    }
    
    private static void test1111() {
        long start = System.currentTimeMillis();
        Roaring64Bitmap roaring64Bitmap = new Roaring64Bitmap();
        for (int i = 0; i < 600_0000; i++) {
            int l = (int) (roaring64Bitmap.getLongCardinality() / 100_0000);
            switch (l) {
                case 0 :
                    roaring64Bitmap.add(13700000000L + i);
                    break;
                case 1 :
                    roaring64Bitmap.add(13500000000L + i);
                    break;
                case 2 :
                    roaring64Bitmap.add(18900000000L + i);
                    break;
                case 3 :
                    roaring64Bitmap.add(17600000000L + i);
                    break;
                case 4 :
                    roaring64Bitmap.add(13300000000L + i);
                    break;
                case 5 :
                    roaring64Bitmap.add(15500000000L + i);
                    break;
                case 6 :
                    roaring64Bitmap.add(17600000000L + i);
                    break;
                default:
                    break;
            }

        }
        System.out.println(roaring64Bitmap.getLongCardinality());
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(roaring64Bitmap.contains(13500000000L));
        try {
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        roaring64Bitmap.clear();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 600_0000; i++) {
            roaring64Bitmap.add(13500000000L + i);
        }
        System.out.println(roaring64Bitmap.getLongCardinality());
        System.out.println(roaring64Bitmap.contains(500_0000));
        System.out.println(System.currentTimeMillis()-startTime);
        try {
            System.out.println("休眠开始");
            TimeUnit.SECONDS.sleep(10);
            System.out.println(roaring64Bitmap.contains(13500000000L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
