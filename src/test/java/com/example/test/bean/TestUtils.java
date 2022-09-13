package com.example.test.bean;


import com.example.test.bean.User;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.BeanUtils;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-12-08  11:32
 */
public class TestUtils {

    public static void main(String[] args) {

//        excapeUtil();
//        testClone();
        testBeanUtils();
    }

    private static void testBeanUtils() {
        Students students = new Students();
        Success success = new Success();
        BeanUtils.copyProperties(students, success);
    }

    private static void excapeUtil() {
        String s = "<pre class=\"brush: java;\">";
        System.out.println(StringEscapeUtils.escapeHtml(s));
        System.out.println(StringEscapeUtils.unescapeHtml(s));

        String u = "<pre class=brush: java;>";
        System.out.println(StringEscapeUtils.unescapeHtml(u));

        String a = "&lt;pre class=&quot;brush: java;&quot;&gt;";
        System.out.println(StringEscapeUtils.unescapeHtml(a));

        String b = "aaa;eqweqwe;eqweqwe;";
        System.out.println(StringEscapeUtils.unescapeHtml(b));
    }

    private static void testClone() {
        User user = new User("zhangsan");
        try {
            User clone = user.clone();
            String name = user.getName();
            name = "111";
            user.setName(name);
            int i  = 2;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}
