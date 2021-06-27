package com.example.demo.controller;


import com.example.demo.bean.Sysuser;
import com.example.demo.service.ISysuserService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/sysuser")
public class SysuserController {

    private static final Logger logger = LoggerFactory.getLogger(SysuserController.class);

    private final ISysuserService sysuserService;

    public SysuserController(ISysuserService sysuserService) {
        this.sysuserService = sysuserService;
    }

    @PostMapping("/getAllSysuser")
    public List<Sysuser> getAllStudent() {
        return sysuserService.list();
    }

    @GetMapping("/test")
    public String test() {
        try {
            sysuserService.addSysuserSyncUIM();
        } catch (Exception e) {
            logger.error("操作员控制层出问题了", e);
        }
        return "";
    }

    @GetMapping("/testOrderby")
    public String testOrderby() {
        List<Sysuser> list = sysuserService.testOrderby();
        System.out.println(list.size());
        return "查询完毕";
    }


    //rpush fruit k1 k2 k3 k4 k5 k6 k7 k8 k9 k10 k11 k12 k13 k14 k15 k16 k17 k18 k19 k20
    @PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {

        Jedis jedis = new Jedis("192.168.3.129",6379);
        String fruit = jedis.lpop("fruit");
        System.out.println(fruit);

        return "fruit";

    }

    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.176:6379").setPassword("123456").setTimeout(3310000).setConnectTimeout(3330000);
        RedissonClient redissonClient = Redisson.create(config);
        RLock rLock = redissonClient.getLock("lock1");

        boolean b;
        try {
            if (!rLock.tryLock(100, TimeUnit.SECONDS)){
                return "请稍等，正在处理";
            }
            b = sysuserService.save(sysuser);
            Thread.sleep(3000);
            rLock.unlock();
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.176:6379").setPassword("123456");
        RedissonClient redissonClient = Redisson.create(config);
        RLock rLock = redissonClient.getLock("lock1");
        rLock.lock();
    }

    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        if (!sysuserService.keepUnique(sysuser.getUserId())){
            return "插入失败";
        }
        boolean b;
        try {
            b = sysuserService.save(sysuser);
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/


    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {

        boolean b;
        try {
            b = sysuserService.insertUnique(sysuser);
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/

}
