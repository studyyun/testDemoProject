package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上行推送业务系统返回的结果
 *
 * @author zhousy
 * @date 2021-05-19  15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoPushResult {
    
    /**返回状态*/
    private String status;

    /**返回信息*/
    private String message;

}
