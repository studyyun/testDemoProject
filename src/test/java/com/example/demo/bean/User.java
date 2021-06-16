package com.example.demo.bean;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-05-17  17:16
 */
public class User {
    
    @JSONField(name = "exno")
    private String name;
    
    private Integer age;
    
    private Students students;

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
