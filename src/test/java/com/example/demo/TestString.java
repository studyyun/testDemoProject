package com.example.demo;

import com.alibaba.fastjson.JSONObject;

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

        Person father = new Person();
        father.setName("我是爸爸");

        Person son = new Person();
        son.setName("我是儿子");

        father.setSon(son);

        String jsonString = JSONObject.toJSONString(father);
        System.out.println(jsonString);

        JSONObject jsonObject = JSONObject.parseObject(jsonString);
        System.out.println(jsonObject.getString("name"));
        JSONObject son1 = jsonObject.getJSONObject("son");
        System.out.println(son1.getString("name"));

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
