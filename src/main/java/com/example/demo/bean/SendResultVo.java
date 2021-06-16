package com.example.demo.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @name: SendResultVo
 * @description: 发送返回结果VO
 * @type: JAVA
 * @since: 2019/6/29 11:37
 * @author: zhaoshuwang
*/
@Data
public class SendResultVo implements Serializable {

    private String result;
    private String code;


    public SendResultVo() {
    }

    public SendResultVo(String result, String code) {
        this.result = result;
        this.code = code;
    }
}
