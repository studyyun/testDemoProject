package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;


/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-15  10:29
 */
public class DateBean {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DateBean(String name) {
        this.name = name;
    }
}
