package com.example.demo.controller;


import com.example.demo.bean.LfMonDbopr;
import com.example.demo.bean.Student;
import com.example.demo.service.ILfMonDboprService;
import com.example.demo.service.IStudentService;
import com.example.demo.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    
    @Autowired(required = false)
    private IStudentService studentService;
    
    private ILfMonDboprService lfMonDboprService;

    public StudentController(ILfMonDboprService lfMonDboprService) {
        this.lfMonDboprService = lfMonDboprService;
    }


    @PostMapping("/getStudent")
    public Student getStudent(){
        return studentService.getById(1);
    }

    @PostMapping("/getAllStudent")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/testTransactional")
    public String testTransactional(){

        try {
            studentService.testTransactional();
        } catch (Exception e) {
            logger.error("控制层报错",e);
        }
        return "";
    }



}
