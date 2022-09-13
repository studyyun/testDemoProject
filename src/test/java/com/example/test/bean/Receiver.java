package com.example.test.bean;

import java.io.Serializable;
import java.util.Map;

/**
 * @author <a href="Mailto:davidsangpower@163.com">author</a>
 * @location com.montnets.common.entity
 * @date 2019/5/28 15:21
 * @since 1.0
 */
public class Receiver implements Serializable {
    private String mobile;
    private String email;
    private Map<String, String> wechat;
    private Long rcvMsgId;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getWechat() {
        return wechat;
    }

    public void setWechat(Map<String, String> wechat) {
        this.wechat = wechat;
    }

    public Long getRcvMsgId() {
        return rcvMsgId;
    }

    public void setRcvMsgId(Long rcvMsgId) {
        this.rcvMsgId = rcvMsgId;
    }

    public Receiver() {
    }

    public Receiver(String mobile, String email) {
        this.mobile = mobile;
        this.email = email;
    }

    public Receiver(String mobile, String email, Map<String, String> wechat) {
        this.mobile = mobile;
        this.email = email;
        this.wechat = wechat;
    }

    public Receiver(String mobile, String email, Map<String, String> wechat, Long rcvMsgId) {
        this.mobile = mobile;
        this.email = email;
        this.wechat = wechat;
        this.rcvMsgId = rcvMsgId;
    }
}
