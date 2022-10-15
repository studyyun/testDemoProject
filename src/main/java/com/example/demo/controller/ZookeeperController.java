package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ZookeeperController {

    private CuratorFramework curatorFramework;

    public ZookeeperController(CuratorFramework curatorFramework) {
        this.curatorFramework = curatorFramework;
    }

    @GetMapping("/mapper")
    private void test() throws Exception {

        //基于临时有序节点来实现的分布式锁.
        InterProcessMutex lock = new InterProcessMutex(curatorFramework, "/Locks");
        try {
            lock.acquire();
        } catch (Exception e) {
            log.error("获取锁失败", e);
        } finally {
            lock.release();
        }
    }
}
