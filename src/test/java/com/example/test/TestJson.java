package com.example.test;

import com.example.test.bean.User;

import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-02  10:16
 */
public class TestJson {

    public static void main(String[] args) {
        User user = new User("zhangsan");
        Map<User, String> map = new HashMap<>();
        map.put(user, "111");
        User user2 = new User("zhangsan");
        System.out.println(map.get(user2));


    }

}
