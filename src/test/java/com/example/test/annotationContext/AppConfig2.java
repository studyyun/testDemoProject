package com.example.test.annotationContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-09  15:30
 */
@Configuration
public class AppConfig2 {
    
    @Bean
    public AnnotationBean3 getBean3(){
        return new AnnotationBean3();
    }

    
}
