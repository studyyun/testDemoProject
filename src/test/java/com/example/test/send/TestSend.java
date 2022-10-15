package com.example.test.send;

import cn.hutool.core.util.CharsetUtil;
import com.alibaba.fastjson.JSONObject;
//import com.montnets.emp.util.MD5;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-08-18  14:58
 */
public class TestSend {
    
    
    
    public static void main(String[] args) {
        try {
            /*String content = "你好啊";
            String userId = "ZSY001";
            String passWord = "123456";
            String mobile = "13548549898";
            //当前时间，月日时分秒，eg:0526160000
            String timeStamp = DateUtil.formatNow(DatePatternConstant.MMDDHHMMSS);
            String encryptPwd = MD5.getMD5Str(userId + "00000000" + passWord + timeStamp);
            String smsSendHttpUrl = "http://192.168.3.176:8082/sms/v2/std/send_single";
            
            content = URLEncoder.encode(content, CharsetUtil.UTF_8);
            SendWgParam param = new SendWgParam(userId, encryptPwd, mobile, content, timeStamp);
            *//*HttpHeaders httpHeaders = new HttpHeaders();
            //设置请求数据类型
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> formEntity = new HttpEntity<>(JSONObject.toJSONString(param), httpHeaders);
            ResponseEntity<SendCustomSmsResult> responseEntity = new RestTemplate().postForEntity(smsSendHttpUrl, formEntity, SendCustomSmsResult.class);
            *//*
            String result = new RestTemplate().postForObject(smsSendHttpUrl, param, String.class);
            System.out.println(result);
            SendCustomSmsResult sendCustomSmsResult = JSONObject.parseObject(result, SendCustomSmsResult.class);
            System.out.println(JSONObject.toJSONString(sendCustomSmsResult));
            
            
            Map<String,Boolean> map = new HashMap<>();*/
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("报错了");
        }
    }
    
}
