package com.example.demo.service;

import com.example.demo.bean.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
public interface IStudentService extends IService<Student> {

    List<Student> getAllStudent();

    void testTransactional() throws Exception;
    
    void testSetterDi();
    
}
