package com.example.demo.controller;

import com.example.demo.service.ILfMonDboprService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-08-13  15:38
 */
@RestController
@RequestMapping("/mondbopr")
public class LfMonDboprController {

    private static final Logger logger = LoggerFactory.getLogger(LfMonDboprController.class);

    private ILfMonDboprService lfMonDboprService;

    public LfMonDboprController(ILfMonDboprService lfMonDboprService) {
        this.lfMonDboprService = lfMonDboprService;
    }

    @GetMapping("/testDeadLock")
    public String testDeadLock() {
        try {
//            LfMonDbopr lfMonDbopr = new LfMonDbopr().setId(19706).setProceNode(1001).setCreateTime(new Timestamp(System.currentTimeMillis()));
            lfMonDboprService.updateRealTime(1001);
            logger.info("1001执行了啦啦啦啦啦啦啦啦");
            return "成功";
        } catch (Exception e) {
            logger.error("报错了啊啊啊啊啊啊啊啊", e);
            return "报错";
        }

    }

    @GetMapping("/testDeadLock2")
    public String testDeadLock2() {
        try {
//            LfMonDbopr lfMonDbopr = new LfMonDbopr().setId(19706).setProceNode(1002).setCreateTime(new Timestamp(System.currentTimeMillis()));
            lfMonDboprService.updateRealTime(1002);
            logger.info("1002执行了啦啦啦啦啦啦啦啦");
            return "成功";
        } catch (Exception e) {
            logger.error("报错了啊啊啊啊啊啊啊啊", e);
            return "失败";
        }
    }

}
