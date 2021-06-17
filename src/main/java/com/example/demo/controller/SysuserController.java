package com.example.demo.controller;


import com.example.demo.bean.Sysuser;
import com.example.demo.service.ISysuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
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
    public List<Sysuser> getAllStudent() {
        return sysuserService.list();
    }

    @GetMapping("/test")
    public String test() {
        try {
            sysuserService.addSysuserSyncUIM();
        } catch (Exception e) {
            logger.error("操作员控制层出问题了", e);
        }
        return "";
    }

    @GetMapping("/testOrderby")
    public String testOrderby() {
        List<Sysuser> list = sysuserService.testOrderby();
        System.out.println(list.size());
        return "查询完毕";
    }

    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        if (!sysuserService.keepUnique(sysuser.getUserId())){
            return "插入失败";
        }
        boolean b;
        try {
            b = sysuserService.save(sysuser);
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/


    @PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        
        boolean b;
        try {
            b = sysuserService.insertUnique(sysuser);
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }

}
