package com.example.test.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-15  10:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateBean {

    public String name;
    
    private int existFlow;
    
    private boolean flag;

    public DateBean(String name) {
        this.name = name;
    }
}
