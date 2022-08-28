package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/redis/test")
    public void testRedis() {

    }

    @GetMapping("/redis/{k}/{v}")
    public String addStringKV(@PathVariable String k,
                              @PathVariable String v) {

        for (int i = 0; i < 100_000; i++) {
            // 使用StringRedisTemplate对象
            stringRedisTemplate.opsForValue().set(k + i, v + i);
        }
        System.out.println("调用结束");
        return "使用StringRedisTemplate对象添加";
    }


}
