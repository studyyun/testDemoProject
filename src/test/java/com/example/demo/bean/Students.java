package com.example.demo.bean;

import com.alibaba.fastjson.JSONObject;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-04  10:02
 */
public class Students {
    
    private long taskId;
    
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public static void main(String[] args) {
        Students students = new Students();
        System.out.println(JSONObject.toJSONString(students));
    }
    
}
