package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-03  10:12
 */
@Data
public class Parent implements Serializable {
    
    private String userName;

    private Integer id;

    public Parent(String userName, Integer id) {
        this.userName = userName;
        this.id = id;
    }

    public Parent() {
    }
}
