package com.example.demo.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-03  10:12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Child extends Parent {
    
    
    private Integer orderNo;

    public Child(String userName, Integer id) {
        super(userName, id);
    }

    public Child() {
    }
}
