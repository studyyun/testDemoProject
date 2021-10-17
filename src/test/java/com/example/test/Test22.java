package com.example.test;

import com.example.test.bean.User;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-30  17:10
 */
public class Test22 {

    private void analyzeMsg(List<User> mtTaskList) {
        if (mtTaskList == null || mtTaskList.size() == 0) {
            return;
        }
        Pattern pattern = Pattern.compile("(动态密码)(.?\\d{6})");
        Pattern pattern2 = Pattern.compile("(验证码)(.?\\d{6})");
        for (User bean : mtTaskList) {
            String msg = (String) bean.getMessage();
            if (StringUtils.isBlank(msg)) {
                continue;
            }
            //一条短信只会出现一次“验证码xxxxxx”或者“动态密码xxxxxx”
            Matcher matcher = pattern.matcher(msg);
            if (matcher.find()) {
                bean.setMessage(msg.replace(matcher.group(),"动态密码******"));
                continue;
            }
            matcher = pattern2.matcher(msg);
            if (matcher.find()) {
                bean.setMessage(msg.replace(matcher.group(),"验证码******"));
            }
        }

    }
    
    public static void main(String[] args) {
        List<User> mtTaskList = new ArrayList<>();
        User user = new User("zhangsan");
        
        user.setMessage("登陆验证码123456手机银行的动态密码：123456dasda答啥");
        mtTaskList.add(user);
        User User2 = new User("lisi");
        User2.setMessage("登陆验证码123456手机银行的动态密码:123456答啥");
        mtTaskList.add(User2);
        User User3 = new User("wangwu");
        User3.setMessage("登陆验证码123456手机银行的动态密码 123456222顶顶顶顶顶");
        mtTaskList.add(User3);
        User User4 = new User("maliu");
        User4.setMessage("登陆验证码手机银行的动态密码五分钟内有效");
        mtTaskList.add(User4);
        new Test22().analyzeMsg(mtTaskList);
        int size = mtTaskList.size();
        System.out.println(size);
    }
    
   /* public static void main(String[] args) {
        String str1 = "登陆手机验证码银行132422的验证码：123456大撒大撒";
        String str2 = "登陆手机验证码银行132422的验证码:123456哇哇哇哇";
        String str3 = "登陆手机验证码银行132422的验证码 123456涛涛涛涛";
        String str4 = "登陆手机验证码银行132422的验证码123456五分钟内有效";
        Pattern pattern = Pattern.compile("(验证码)(.?\\d{6})");
        Matcher matcher = pattern.matcher(str1);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(str1.replace(group,"验证码******"));

//            System.out.println(str1.substring(0, matcher.start()+3) + "******" + str1.substring(matcher.end()));

        }


        matcher = pattern.matcher(str2);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            System.out.println(str2.replace(group,"验证码******"));
//            System.out.println(str2.substring(0, matcher.start()+3) + "******" + str2.substring(matcher.end()));
        }

        matcher = pattern.matcher(str3);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            System.out.println(str3.replace(group,"验证码******"));
//            System.out.println(str3.substring(0, matcher.start()+3) + "******" + str3.substring(matcher.end()));
        }

        matcher = pattern.matcher(str4);
        if (matcher.find()) {
            String group = matcher.group();
            System.out.println(group);
            System.out.println(str4.replace(group,"验证码******"));
//            System.out.println(str4.substring(0, matcher.start()+3) + "******" + str4.substring(matcher.end()));
        }
    }*/

}
