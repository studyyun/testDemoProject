package com.example.test.bean;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 邮箱所有接收者，收件、抄送、密送
 *
 * @author zhousy
 * @date 2021-12-09  14:34
 */
@Data
public class EmailAllReceiver {

    @ApiModelProperty(value = "收件人邮箱集合")
    private List<String> receiverList;
    
    @ApiModelProperty(value = "抄送人邮箱集合")
    private List<String> ccReceiverList = new ArrayList<>();

    @ApiModelProperty(value = "密送人邮箱集合")
    private List<String> bCcReceiverList = new ArrayList<>();
    
}
