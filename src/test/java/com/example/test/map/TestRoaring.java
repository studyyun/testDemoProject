package com.example.test.map;

import org.roaringbitmap.longlong.Roaring64Bitmap;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-20  15:37
 */
public class TestRoaring {

    public static void main(String[] args) {
        Roaring64Bitmap rbAnd = new Roaring64Bitmap();
        for (long k = 10000; k < 20000; k++) {
            rbAnd.add(k);
        }

        Roaring64Bitmap rbAnd2 = new Roaring64Bitmap();
        for (long k = 15000; k < 20000; k++) {
            rbAnd2.add(k);
        }

        rbAnd.and(rbAnd2);
        System.out.println("roaring64Bitmap结果个数为：" + rbAnd.getLongCardinality());

        Roaring64Bitmap rbAnd3 = new Roaring64Bitmap();
        for (long k = 100000; k < 200000; k++) {
            rbAnd3.add(k);
        }

        Roaring64Bitmap rbAnd4 = new Roaring64Bitmap();
        for (long k = 150000; k < 200000; k++) {
            rbAnd4.add(k);
        }

        rbAnd3.and(rbAnd4);
        System.out.println("roaring64Bitmap结果个数为：" + rbAnd3.getLongCardinality());
    }
    
}
