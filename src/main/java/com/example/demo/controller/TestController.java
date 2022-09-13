package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.MoPushRequestData;
import com.example.demo.bean.MoPushResult;
import com.example.demo.bean.SendResultVo;
import com.example.demo.service.impl.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-23  23:49
 */
@Controller
@CrossOrigin
@Slf4j
public class TestController {

    /**
     * 获取code授权码地址
     */
    @Value("${oauth2.code_uri2:http://192.168.1.176:9090/open-id?param=hahahah}")
    private String codeUri;
    /**
     * 获取token令牌地址
     */
    @Value("${oauth2.token_uri:https://sso.ubrmbqa.com/auth/realms/ubrmbtest/protocol/openid-connect/token}")
    private String tokenUri;
    /**
     * 注销地址
     */
    @Value("${oauth2.logout_uri2:https://sso.ubrmbqa.com/auth/realms/ubrmbtest/protocol/openid-connect/logout}")
    private String logoutUri;
    
    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @RequestMapping("/")
    public String testhello(HttpServletRequest request,HttpServletResponse response) throws IOException {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            System.out.println(s + ":" + request.getHeader(s));
        }
        /*ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes)!= -1){
            System.out.println(new String(bytes));
        }
        response.getWriter().print("你好");*/
//        response.sendRedirect(codeUri);
//        System.out.println("222");
        return "redirect:/emp/sso";
    }

    @RequestMapping("/emp/sso")
    public String empSso(HttpServletRequest request,HttpServletResponse response) throws IOException {
        /*ServletInputStream inputStream = request.getInputStream();
        byte[] bytes = new byte[1024];
        while (inputStream.read(bytes)!= -1){
            System.out.println(new String(bytes));
        }
        response.getWriter().print("你好");*/
//        response.sendRedirect(codeUri);
//        System.out.println("333");
        return "redirect:/index.html";
    }
    
    @PostMapping("/test/moPush")
    @ResponseBody
    public MoPushResult testMoPush(@RequestBody MoPushRequestData requestData){
        try {
            log.error("上行消息推送过来了，消息内容为：{}",JSONObject.toJSONString(requestData));
            return new MoPushResult("success","成功了");
        } catch (Exception e) {
            log.error("报错了，推送的上行消息为：{}",JSONObject.toJSONString(requestData),e);
            return new MoPushResult("fail","服务端有报错了");
        }

    }
    
    @GetMapping("/testSpeed")
    @ResponseBody
    public SendResultVo testSpeed(){
        System.out.println("1111");
        return new SendResultVo();
    }

    @GetMapping("/testFile")
    @ResponseBody
    public SendResultVo testFile() throws Exception{
        System.out.println("1111");
        File file = new File("filetest.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("hello\r\nhi".getBytes());
        }
        return new SendResultVo();
    }

    @GetMapping("/testDiff")
    public Boolean testDiff() {

        try {
            testService.testDiff();
            return true;
        } catch (Exception e) {
            log.error("出错啦", e);
            return false;
        }
    }

    @GetMapping("/testProduce")
    public SendResultVo testProduce() {

        try {
            testService.testProduce();
            return null;
        } catch (Exception e) {
            log.error("出错啦", e);
            return null;
        }
    }

    @GetMapping("/testParent")
    public SendResultVo testParent() {

        try {
            testService.testParent();
            return null;
        } catch (Exception e) {
            log.error("出错啦", e);
            return null;
        }
    }

    @GetMapping("/testWrapper")
    public SendResultVo testWrapper() {

        try {
            testService.testWrapper();
            return null;
        } catch (Exception e) {
            log.error("出错啦", e);
            return null;
        }
    }

    @GetMapping("/testTime")
    public SendResultVo testTime() {

        try {
            testService.testTime();
            return new SendResultVo();
        } catch (Exception e) {
            log.error("出错啦", e);
            return new SendResultVo();
        }
    }

    public static void main(String[] args) {
//        System.out.println(null + "qewwrqr");
        String str = "abc11123";
        System.out.println(str.endsWith("23"));
        System.out.println(str.endsWith("3"));
    }
    
}
