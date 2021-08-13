package com.example.test;

import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-23  22:26
 */
public class TestRedis {

    public static void main(String[] args) {
        Config config = new Config();
        String cluster = "192.169.1.68:7001,192.169.1.68:7002,192.169.1.68:7003,192.169.1.68:7004,192.169.1.68:7005,192.169.1.68:7006";
        String[] nodes = cluster.split(",");
        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = "redis://" + nodes[i];
        }
        config.setCodec(new StringCodec()).useClusterServers().addNodeAddress(nodes)//设置集群状态扫描时间2000
                .setScanInterval(2000)
                
                .addNodeAddress(nodes)
//                    .setPassword(password)
                .setMasterConnectionPoolSize(1000)
                //最小空闲连接
                .setMasterConnectionMinimumIdleSize(0);
        RedissonClient redissonClient = Redisson.create(config);
        RList<Object> testList = redissonClient.getList("testList");
        
        for (int i = 0; i < 20; i++) {
            testList.add("k" + i);
        }
//        Jedis 
    }
    
}
