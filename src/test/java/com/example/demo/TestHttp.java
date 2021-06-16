package com.example.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-02-24  11:52
 */
public class TestHttp {

    public static String getYmd(long ptMsgId) {
        String s = Long.toBinaryString(ptMsgId);
        long l = ptMsgId >> 60;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
        long mon = l & 15;
        if (mon == 12 && month == 1) {
            year --;
        }
        long l1 = ptMsgId >> 55;
        long day = l1 & 31;
        return year + String.format("%02d", mon) + String.format("%02d", day);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
//        HttpClients.createDefault().execute(new HttpGet("http://localhost:9999/")).getEntity().getContent();
//        System.out.println(TestHttp.getYmd(4876006416382427140L));

//       String regex = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

        //以英文字母数字开头结尾，账号部分4-21个字符，可出现字母，数字，短横线，点
        //域名部分，可出现二级域名，3级域名等等，以2到3个字符的字母数字结尾
        /*String regex = "^[A-Za-z0-9][\\w\\-.]{3,20}@([\\w\\-]+\\.)+[\\w]{2,3}$";
        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher("Stephen.Zhang@universalbeijing.com");
        Matcher matcher = pattern.matcher("Ac-p._sit@notify.universalbeijing.com");
        System.out.println(matcher.find());*/

        /*User user = new User();
        user.setAge(10);
        user.setName("hahaha");
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<String> formEntity = new HttpEntity<>(JSONObject.toJSONString(user), httpHeaders);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(formEntity);
        System.out.println(user);*/
        
        while (true){
            System.out.println(111);
            Thread.sleep(1000);
        }
    }

}

class User{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
