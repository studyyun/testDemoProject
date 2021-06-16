package com.example.demo.controller;


import com.example.demo.bean.Student;
import com.example.demo.bean.Sysuser;
import com.example.demo.service.ISysuserService;
import com.example.demo.service.impl.StudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
@RestController
@RequestMapping("/sysuser")
public class SysuserController {

    private static final Logger logger = LoggerFactory.getLogger(SysuserController.class);

    private final ISysuserService sysuserService;

    public SysuserController(ISysuserService sysuserService) {
        this.sysuserService = sysuserService;
    }

    @PostMapping("/getAllSysuser")
    public List<Sysuser> getAllStudent(){
        return sysuserService.list();
    }

    @GetMapping("/test")
    public String test(){
        try {
            sysuserService.addSysuserSyncUIM();
        } catch (Exception e) {
            logger.error("操作员控制层出问题了",e);
        }
        return "";
    }
    
    @GetMapping("/testOrderby")
    public String testOrderby(){
        List<Sysuser> list = sysuserService.testOrderby();
        System.out.println(list.size());
        return "查询完毕";
    }

}
