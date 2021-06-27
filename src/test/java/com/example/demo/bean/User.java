package com.example.demo.bean;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-05-17  17:16
 */
@Data
@Accessors(chain = true)
public class User {

    private String name;

    private Integer age;

    private Students students;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }
}
