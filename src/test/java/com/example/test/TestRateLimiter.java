package com.example.test;

import cn.hutool.core.date.DateUtil;
import com.google.common.util.concurrent.RateLimiter;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2022-02-21  14:18
 */
public class TestRateLimiter {

    public static void main(String[] args) {
        RateLimiter rateLimiter = RateLimiter.create(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                rateLimiter.acquire();
                System.out.println(DateUtil.now());
            }).start();
        }

    }

}
