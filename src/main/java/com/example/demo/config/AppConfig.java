package com.example.demo.config;

import com.baomidou.mybatisplus.autoconfigure.SpringBootVFS;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.example.demo.bean.DateBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-06-29  15:04
 */
@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Autowired
    public Environment environment;

    @Bean
    public DateBean dateBean(){
        return new DateBean(environment.getProperty("server.port"));
    }

    @Bean
    public MybatisSqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws Exception {
        // TODO 使用 MybatisSqlSessionFactoryBean 而不是 SqlSessionFactoryBean
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
//        return factory.getObject();
        return factory;
    }
}
