package com.example.demo.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-29  14:44
 */
@Component
public class TestBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.printf("嘿嘿，初始化之后执行，beanName为：%s，-------bean为：%s\n", beanName, bean.toString());
        return bean;
    }
}
