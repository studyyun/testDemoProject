package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Student;
import com.example.demo.bean.Students;
import com.example.demo.bean.User;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.*;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-23  17:40
 */
@Slf4j
public class Test1 {
    private static ArrayList<Integer> list = new ArrayList<>();
    
    
    public static void main(String[] args) throws InterruptedException, UnsupportedEncodingException {

        /*User user = new User("zhangsan");

        HttpHeaders httpHeaders = new HttpHeaders();
        //设置请求数据类型
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> formEntity = new HttpEntity<>(JSONObject.toJSONString(user), httpHeaders);
        System.out.println(formEntity);*/

        /*User user = new User("hahaha");
        User user2 = new User("hahaha");

        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        log.info("{}", JSONObject.toJSONString(list));
        log.info("{}", list);*/
        
        /*Map<String, String> map = new ConcurrentHashMap<>(16);
        map.entrySet().iterator();
        
        TimeUnit unit;
        BlockingQueue workQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 0
                , TimeUnit.SECONDS, new LinkedBlockingQueue<>(1024));
        threadPoolExecutor.execute(new ThreadA());
        threadPoolExecutor.execute(new ThreadB());*/

        Students student = new Students();
        student.setAddress("www");
        User user = new User("zhangsan");
        user.setStudents(student);
        System.out.println(JSONObject.toJSONString(user));
        student.setAddress("qqq");
        System.out.println(JSONObject.toJSONString(user));

    }

}

class ThreadA extends Thread{

    @Override
    public void run() {
        super.run();
        System.out.println("nihao");
    }
}

class ThreadB implements Runnable{

    @Override
    public void run() {
        System.out.println("hahahaha");
    }
}
