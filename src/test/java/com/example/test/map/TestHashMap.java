package com.example.test.map;

import com.example.test.bean.SanwInfo;
import com.koloboke.collect.map.hash.HashLongObjMap;
import com.koloboke.collect.map.hash.HashLongObjMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-01  15:38
 */
public class TestHashMap {

    public static void main(String[] args) {
        
        test11();
        
        /*Map<Long, Long> map = new HashMap<Long, Long>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 600_0000; i++) {
            map.put(13500000000L + i, 13500000000L + i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(map.size());

        map.clear();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 600_0000; i++) {
            map.put(13500000000L + i, 13500000000L + 2 * i);
        }
        System.out.println(System.currentTimeMillis() - start);
        
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        
    }

    private static void test11() {
        HashMap<Long, Object> map = new HashMap<>();
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);
        for (int i = 0; i < 600_0000; i++) {
            SanwInfo sanwInfo = new SanwInfo().setCapitalAccount("123123").setDislikeType("A").setEvalLevel("3").setInvestDuration("A").setMobile("13548546464");
            map.put(13500000000L + i, sanwInfo);
//            map.put("13500000000" + i, "13500000000L" + i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        for (int i = 0; i < 10; i++) {
            Object o = map.get(13500000000L);
            int k = 0;
        }
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
