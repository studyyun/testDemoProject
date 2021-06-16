package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 上行推送业务系统请求参数
 *
 * @author zhousy
 * @date 2021-05-19  15:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoPushRequestData {
    
    /**上行手机号码*/
    private String phoneNo;

    /**上行回复消息*/
    private String smsContents;

    /**上行回复的时间 yyyy-MM-dd HH:mm:ss */
    private String replyTime;
    
    /**下行的自定义流水号*/
    private String custid;
}
