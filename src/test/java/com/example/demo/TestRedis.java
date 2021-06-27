package com.example.demo;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

public class TestRedis {

    public static void main(String[] args) throws InterruptedException {

        Jedis jedis = new Jedis("192.168.3.129",6379);
        System.out.println(jedis.ping());
        /*
        Students students = new Students(856466351L,"长沙市");
        User user = new User().setName("zhanagsan").setAge(20).setStudents(students);
//        System.out.println(String.valueOf(user.hashCode()));
        jedis.set("lock", JSONObject.toJSONString(user), "NX", "EX", 20);*/
//        String luaScript = "return {KEYS[1],KEYS[1],ARGV[1],ARGV[2]}";
        String luaScript = "if (redis.call('exists', KEYS[1]) == 0) then " +
                "redis.call('set', KEYS[1], ARGV[1]); " +
                "redis.call('expire', KEYS[1], ARGV[3]); " +
                "return redis.call('ttl', KEYS[1]); " +
             "end; ";

                /*"if (redis.call('exists', KEYS[2] == 0) then " +
                "redis.call('set', KEYS[2], ARGV[2]); " +
                "redis.call('expire', KEYS[2], ARGV[3]); " +
                "return nil; " +
                "end; " +
                "return redis.call('ttl', KEYS[1]);"*/


//        Object o = jedis.eval(luaScript, Lists.newArrayList("userName", "age"), Lists.newArrayList("Jack", "20", "1500"));
//        System.out.println(o);

        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.129:6379");
        RedissonClient client = Redisson.create(config);
        RLock rLock = client.getLock("testLock");
        rLock.lock();
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        rLock.unlock();
        client.shutdown();
//        jedis.shutdown();
//        TimeUnit.SECONDS.sleep(60);
        /*Map<String,String> map = new HashMap<>(16);
        map.put("name",user.getName());
        map.put("age", String.valueOf(user.getAge()));
        map.put("student", JSONObject.toJSONString(user.getStudents()));
        List<String> values = jedis.hmget("k3", "name", "age", "student");
        values.forEach(System.out::println);*/
//        String result = jedis.hmset("k4", map);
//        Long aLong = jedis.hset("k2", String.valueOf(user.hashCode()), JSONObject.toJSONString(user));
//        System.out.println(result);
        /*String s = jedis.hget("k2",String.valueOf(user.hashCode()));
        System.out.println(s);
        User user1 = JSON.parseObject(s, User.class);
        System.out.println(user1.toString());
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject.toJavaObject(User.class).toString());*/


    }

}
