package com.example.test;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-25  11:12
 */
public class TestGetBean implements ApplicationContextAware {

    public ApplicationContext applicationContext; 
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext = this.applicationContext;
    }
}
