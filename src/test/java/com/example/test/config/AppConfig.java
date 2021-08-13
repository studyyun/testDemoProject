package com.example.test.config;

import com.example.test.bean.DateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-29  15:04
 */
@Configuration
@PropertySource("{classpath:application.properties}")
public class AppConfig {
    
    @Autowired
    public Environment environment;

    @Bean
    public DateBean dateBean(){
        return new DateBean(environment.getProperty("server.port"));
    }
    
    
}
