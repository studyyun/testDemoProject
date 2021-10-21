package com.example.test;


import cn.hutool.core.lang.Assert;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.bean.Sysuser;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-02  10:16
 */
@Slf4j
public class TestJson {

    public static void main(String[] args) {
        /*try {
            User user = new User("zhangsan");
            user.setAge(20);

            
            
        } catch (Exception e) {
            System.out.println("报错啦");
        }*/
        
        /*Students students = new Students();
        students.setAddress("长沙");
        students.setTaskId(46513L);
        user.setStudents(students);

        String s = JSONObject.toJSONString(user);
        System.out.println(s);
        JSONObject jsonObject = JSONObject.parseObject(s);
        String s1 = jsonObject.getString("students");
        System.out.println(s1);*/
        
        /*Students students = new Students();
        students.setAddress("changsha");
        students.setTaskId(123123L);

        Students students2 = new Students();
        students2.setAddress("beijing");
        students2.setTaskId(3213213L);

        List<Students> list = new ArrayList<Students>(){{
            this.add(students);
            this.add(students2);
        }};

        String listJson = JSONObject.toJSONString(list);
        System.out.println(listJson);

        List<Students> studentsList = JSONObject.parseArray(listJson, Students.class);
        

        user.setStudentsList(list);

        String userJson = JSONObject.toJSONString(user);
        System.out.println(userJson);*/

        /*String str = "dasdaw验证码123456789101112";
        int i = str.lastIndexOf("验证码");
//        int endIndex = (i + 10) <= str.length() ? (i + 10) : str.length();
        String s = str.substring(0,i+3) + "******" + ((i + 10) <= str.length() ? str.substring(i + 10) : "");
//        String substring = str.substring(i+3, endIndex);
        System.out.println(s);

        String[] strs = str.split("验证码");
        String stt = strs[0] + "验证码******" + (strs[1].length() >= 7 ? strs[1].substring(7) : "");
        System.out.println(stt);*/

        try {
            String str = null;
            Assert.notNull(str,"业务短信预览，查询不到机构，机构ID为：{}","wqeqwesda");
//            Assert.notBlank(str, "产品代码为空");
        } catch (Exception e) {
            log.error("报错啦",e);
        }
    }

}
