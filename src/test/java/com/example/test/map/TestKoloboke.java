package com.example.test.map;

import com.example.test.bean.SanwInfo;
import com.koloboke.collect.map.hash.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-16  11:36
 */
public class TestKoloboke {

    public static void main(String[] args) {
//        test22();
//        test11();

        HashLongLongMap CUSTOMER_MAP = HashLongLongMaps.newMutableMap();
        CUSTOMER_MAP.put(111L,0L);
        System.out.println(CUSTOMER_MAP.containsKey(111L));
        
        /*HashLongLongMap map = HashLongLongMaps.newMutableMap();
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);
        for (int i = 0; i < 600_0000; i++) {
            map.put(13500000000L + i, 13500000000L + i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(map.size());
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < 600_0000; i++) {
            map.put(13500000000L + i, 13500000000L + 2 * i);
        }
        System.out.println(System.currentTimeMillis() - start);*/
        
        
    }

    private static void test11() {
        HashLongLongMap map = HashLongLongMaps.newMutableMap();
//        HashLongObjMap<Object> map = HashLongObjMaps.newMutableMap();
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);
        for (int i = 0; i < 600_0000; i++) {
            /*SanwInfo sanwInfo = new SanwInfo().setCapitalAccount("123123").setDislikeType("A").setEvalLevel("3").setInvestDuration("A").setMobile("13548546464");
            map.put(13500000000L + i, sanwInfo);*/
            
            map.put(13500000000L + i,13500000000L + i);
            
//            map.put("13500000000" + i, "13500000000L" + i);
        }
        System.out.println(map.containsKey(13500000000L));
        System.out.println(System.currentTimeMillis() - startTime);
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void test22() {
        HashLongShortMap map = HashLongShortMaps.newMutableMap();
//        HashLongObjMap<Object> map = HashLongObjMaps.newMutableMap();
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间" + startTime);
        for (int i = 0; i < 600_0000; i++) {
            SanwInfo sanwInfo = new SanwInfo().setCapitalAccount("123123").setDislikeType("A").setEvalLevel("3").setInvestDuration("A").setMobile("13548546464");
            short m = (short) (sanwInfo.getInvestDuration().charAt(0) - 'A') ;
            short n = (short) (sanwInfo.getDislikeType().charAt(0) - 'A');
            short k = (short) (sanwInfo.getEvalLevel().charAt(0) - '0');
            short res = (short) ((m << 10) | (n << 5) | k);
            map.put(13500000000L + i, res);
//            map.put(13500000000L + i, sanwInfo);
//            map.put("13500000000" + i, "13500000000L" + i);
        }
        System.out.println(map.size());
        System.out.println(System.currentTimeMillis() - startTime);
        long start = System.currentTimeMillis();
        map.clear();
        System.out.println(map.size());
        System.out.println(System.currentTimeMillis() - start);
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
