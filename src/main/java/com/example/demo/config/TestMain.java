package com.example.demo.config;

import com.example.demo.bean.DateBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-15  17:08
 */
public class TestMain {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        DateBean bean = applicationContext.getBean(DateBean.class);
        System.out.println(bean.name);
    }
    
}
