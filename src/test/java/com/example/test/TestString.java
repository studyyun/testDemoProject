package com.example.test;

import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-03-19  11:31
 */
public class TestString {

    public static void main(String[] args) {
        /*String name = "";
        Person person = new Person();
        person.setName(name);
        String comm = "";
        for (int i = 0; i < person.getName().length(); i++) {
            if ((i + 1) % 2 == 0) {
                comm = comm + person.getName().charAt(i);
            }
        }
        System.out.println("结束啦" + person.getName());
        System.out.println("结束啦222" + comm);*/

        /*String s = "E:\\IDEA Projects\\testLinuxFile\\file\\10.23\\rms2DB.0.log";
        System.out.println(s.contains("rms2DB"));*/

        User user1 = new User("111",100);
        User user2 = new User("222",100);
        User user3 = new User("333",100);
        User user4 = new User(null,100);
        User user5 = new User("",100);

        List<User> list = new ArrayList<User>(){{
            add(user1);
            add(user2);
            add(user3);
            add(user4);
            add(user5);
        }};

        for (int i = 0; i < 500_0000; i++) {
            list.add(new User("111", 100));
        }

        try {
            Map<String, List<String>> result = list.stream().collect(Collectors.groupingBy(item -> {
                if (item.getName() == null) {
                    return "3";
                }
                if (item.getName().contains("1")) {
                    return "1";
                } else if (item.getName().contains("2")) {
                    return "1";
                } else if (item.getName().contains("3")) {
                    return "2";
                } else {
                    return "2";
                }
            }, Collectors.mapping(User::getName, Collectors.toList())));
            int i = 2;
        } catch (Exception e) {
            e.printStackTrace();
        }


        List<String> list1 = new ArrayList<>();
        list1.add(null);
        list1.add(null);

        int i = 0;
    }

}

class Person{
    private String name;

    private Person son;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getSon() {
        return son;
    }

    public void setSon(Person son) {
        this.son = son;
    }
}
