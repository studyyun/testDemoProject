package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.*;
import org.redisson.client.codec.DoubleCodec;
import org.redisson.client.codec.StringCodec;
import org.redisson.config.Config;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestRedis {

    private static void insertBatch(){
        Config config = new Config();
        config.setCodec(StringCodec.INSTANCE).useSingleServer().setAddress("redis://192.168.3.129:6379").setDatabase(1);
        RedissonClient client = Redisson.create(config);
        RBatch rBatch = client.createBatch();
        for (int i = 0; i < 1000; i++) {
            RBucketAsync<Object> rBatchBucket = rBatch.getBucket("keys:" + i);
            rBatchBucket.setAsync("v:" + i);
        }
        rBatch.execute();
        client.shutdown();
    }

    private static boolean limiting(String userId, String action, int maxCount, int period) throws ExecutionException, InterruptedException {

        Integer now = null;
        try {
            Config config = new Config();
            config.setCodec(DoubleCodec.INSTANCE).useSingleServer().setAddress("redis://192.168.3.129:6379");
            RedissonClient client = Redisson.create(config);

        /*RMap<Object, Object> testMap = client.getMap("testMap");
        testMap.addAndGet("m5",1);
        testMap.expire(60, TimeUnit.SECONDS);
        testMap.put("m4", JSONObject.toJSONString(new User("zhaoliu")));
        System.out.println(testMap.get("m5"));*/

        /*RList<Object> list = client.getList("l1");
        list.addAll(Arrays.asList("v2","v3","v4"));*/

        /*RSet<Object> rSet = client.getSet(UUID.randomUUID().toString() + "-" + userId);
        rSet.add("str2");
        rSet.add("str1");
        rSet.expire(60, TimeUnit.SECONDS);*/

        /*RBucket<String> rBucket = client.getBucket("userId");
        String s = rBucket.get();
        if (s == null){
            rBucket.set("0");
        }else {
            rBucket.set((Integer.valueOf(s) + 1) + "");
        }
        System.out.println(s);*/

            RRateLimiter rateLimiter = createRateLimiter(client);
            rateLimiter.acquire(1);
            CountDownLatch countDownLatch = new CountDownLatch(20);
            for (int i = 0; i < 19; i++) {
                new Thread(()->{
                    rateLimiter.acquire(1);
                    System.out.printf("%s，获取到了令牌 \n",Thread.currentThread().getName());
                    countDownLatch.countDown();
                }).start();
            }
            countDownLatch.await();
            System.out.println(Thread.currentThread().getName());
            client.shutdown();
            return true;
        } catch (Exception e) {
            log.error("报错了", e);
            return false;
        }

    }

    private static boolean limitingJedis(String userId, String action, int maxCount, int period) throws ExecutionException, InterruptedException {

        Integer now = null;
        try {
            Config config = new Config();
            config.setCodec(StringCodec.INSTANCE).useSingleServer().setAddress("redis://192.168.3.129:6379");
            RedissonClient client = Redisson.create(config);

        /*RMap<Object, Object> testMap = client.getMap("testMap");
        testMap.addAndGet("m5",1);
        testMap.expire(60, TimeUnit.SECONDS);
        testMap.put("m4", JSONObject.toJSONString(new User("zhaoliu")));
        System.out.println(testMap.get("m5"));*/

        /*RList<Object> list = client.getList("l1");
        list.addAll(Arrays.asList("v2","v3","v4"));*/

        /*RSet<Object> rSet = client.getSet(UUID.randomUUID().toString() + "-" + userId);
        rSet.add("str2");
        rSet.add("str1");
        rSet.expire(60, TimeUnit.SECONDS);*/

        /*RBucket<String> rBucket = client.getBucket("userId");
        String s = rBucket.get();
        if (s == null){
            rBucket.set("0");
        }else {
            rBucket.set((Integer.valueOf(s) + 1) + "");
        }
        System.out.println(s);*/

            RBatch batch = client.createBatch();
            RScoredSortedSetAsync<Object> sortedSet = batch.getScoredSortedSet(action + "：" + userId);
            sortedSet.addAsync(System.currentTimeMillis(),System.currentTimeMillis());
            sortedSet.removeRangeByScoreAsync(0, true, System.currentTimeMillis() - period * 1000, true);
            sortedSet.expireAsync(period + 1, TimeUnit.SECONDS);
            RFuture<Integer> integerRFuture = batch.getScoredSortedSet(action + "：" + userId).sizeAsync();
            now = integerRFuture.join();
            batch.execute();

            client.shutdown();
            return true;
        } catch (Exception e) {
            log.error("报错了", e);
            return false;
        }

    }

    private static RRateLimiter createRateLimiter(RedissonClient client){
        RRateLimiter rateLimiter = client.getRateLimiter("myRateLimiter");
        rateLimiter.trySetRate(RateType.OVERALL, 15, 2000, RateIntervalUnit.SECONDS);
        return rateLimiter;
    }

    private static void bfaddTest() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.129:6379");
        RedissonClient client = Redisson.create(config);
        RBloomFilter<Object> bloomFilter = client.getBloomFilter("b1",new StringCodec());
        System.out.println(bloomFilter.tryInit(10000, 0.01));
        for (int i = 0; i < 10000; i++) {
//            System.out.println(i);
            boolean add = bloomFilter.add("v" + i);
            if (!add){
                System.out.println(i);
                break;
            }

        }
//        System.out.println(bloomFilter.add("v2"));
        client.shutdown();
    }


    private static void pfaddTest() {

        Jedis jedis = new Jedis("192.168.3.129", 6379);
        for (int i = 1; i <= 100000; i++) {
            jedis.pfadd("p1", "user" + i);
        }
        long pfcount = jedis.pfcount("p1");
        System.out.println(pfcount);

    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        /*Jedis jedis = new Jedis("192.168.3.129", 6379);
        System.out.println(jedis.ping());*/


//        boolean result = TestRedis.limiting("zhangsan", "sleepling", 5, 60);
        TestRedis.insertBatch();


        /*
        Students students = new Students(856466351L,"长沙市");
        User user = new User().setName("zhanagsan").setAge(20).setStudents(students);
//        System.out.println(String.valueOf(user.hashCode()));
        jedis.set("lock", JSONObject.toJSONString(user), "NX", "EX", 20);*/
//        String luaScript = "return {KEYS[1],KEYS[1],ARGV[1],ARGV[2]}";

        /*String luaScript = "if (redis.call('exists', KEYS[1]) == 0) then " +
                "redis.call('set', KEYS[1], ARGV[1]); " +
                "redis.call('expire', KEYS[1], ARGV[3]); " +
                "return redis.call('ttl', KEYS[1]); " +
                "end; ";*/

                /*"if (redis.call('exists', KEYS[2] == 0) then " +
                "redis.call('set', KEYS[2], ARGV[2]); " +
                "redis.call('expire', KEYS[2], ARGV[3]); " +
                "return nil; " +
                "end; " +
                "return redis.call('ttl', KEYS[1]);"*/


//        Object o = jedis.eval(luaScript, Lists.newArrayList("userName", "age"), Lists.newArrayList("Jack", "20", "1500"));
//        System.out.println(o);

        /*Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.129:6379");
        RedissonClient client = Redisson.create(config);
        RLock rLock = client.getLock("testLock");
        rLock.lock();
        TimeUnit.SECONDS.sleep(5);
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
        rLock.unlock();
        client.shutdown();*/

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
