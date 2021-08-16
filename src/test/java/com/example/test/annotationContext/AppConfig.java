package com.example.test.annotationContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-09  15:30
 */
@Configuration
//@Import(AppConfig2.class)
public class AppConfig {
    
    @Autowired
    public AppConfig2 appConfig2;
    
    @Bean
    public AnnotationBean getBean(){
        return new AnnotationBean(getBeanOther());
    }

    @Bean
    public AnnotationBean getBean_two(){
        return new AnnotationBean(getBeanOther());
    }
    
    @Bean
    public AnnotationBean2 getBeanOther(){
        return new AnnotationBean2();
    }
    
}
