package com.example.demo.test;

import com.alibaba.fastjson.JSON;
import com.example.demo.bean.Student;
import com.example.demo.mapper.StudentMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;


/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-08-16  11:16
 */
public class TestMybatis {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/test");
        properties.setProperty("username", "root");
        properties.setProperty("password", "123456");
        PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
        pooledDataSourceFactory.setProperties(properties);
        DataSource dataSource = pooledDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(StudentMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            List<Student> allUser = mapper.findAllUser();
            allUser.forEach(user -> System.out.println(JSON.toJSONString(user)));
        }

    }
    
}
