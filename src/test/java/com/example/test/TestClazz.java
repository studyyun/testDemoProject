package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClazz {

    public static void main(String[] args) {
        List<Class<?>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(TestClazz.class);
        }
        System.out.println(list.size());
        Class<TestClazz> aClass = TestClazz.class;
        Class<TestClazz> bClass = TestClazz.class;

        Map<Class<?>, Object> map = new HashMap<>();
        map.put(aClass, new Object());
        map.put(bClass, new Object());

        System.out.println(map.size());
    }

}
