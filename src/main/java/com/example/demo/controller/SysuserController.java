package com.example.demo.controller;


import com.example.demo.bean.Sysuser;
import com.example.demo.service.IStudentService;
import com.example.demo.service.ISysuserService;
import com.example.demo.service.impl.TestService;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private ISysuserService sysuserService;
    private Set<ISysuserService> sysuserServiceSet;
    private Map<String, ISysuserService> sysuserServiceMap;

    @Autowired
    private ISysuserService[] iSysuserServices;
    
    @Autowired
    private IStudentService iStudentService;

    private final ApplicationContext applicationContext;

    public SysuserController(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Autowired
    public void test(@Qualifier("sysuserServiceImpl_Two") ISysuserService sysuserService) {
        this.sysuserService = sysuserService;
    }

    @Autowired
    public void testSet(Set<ISysuserService> sysuserService) {
        this.sysuserServiceSet = sysuserService;
    }

    @Autowired
    public void testMap(Map<String, ISysuserService> sysuserService) {
        this.sysuserServiceMap = sysuserService;
    }

    @Autowired(required = false)
    public void setiStudentService(IStudentService iStudentService) {
        this.iStudentService = iStudentService;
    }
    
    /*
    public SysuserController(ISysuserService sysuserService) {
        this.sysuserService = sysuserService;
    }*/
    
    /*@Autowired
    public void setTestService(@Qualifier("public") TestService test){
        
    }*/

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

    @GetMapping("/addSysuser")
    public String addSysuser() {

        /*Config config = new Config();
        String cluster = "192.169.1.68:7001,192.169.1.68:7002,192.169.1.68:7003,192.169.1.68:7004,192.169.1.68:7005,192.169.1.68:7006";
        String[] nodes = cluster.split(",");
        //redisson版本是3.5，集群的ip前面要加上“redis://”，不然会报错，3.2版本可不加
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = "redis://" + nodes[i];
        }
        config.useClusterServers().addNodeAddress(nodes)//设置集群状态扫描时间2000
                .setScanInterval(2000)
                .addNodeAddress(nodes)
//                    .setPassword(password)
                .setMasterConnectionPoolSize(1000)
                //最小空闲连接
                .setMasterConnectionMinimumIdleSize(0);
        RedissonClient redissonClient = Redisson.create(config);
        RList<Object> testList = redissonClient.getList("testList");*/

        /*Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.169.1.68", 7001));
        nodes.add(new HostAndPort("192.169.1.68", 7002));
        nodes.add(new HostAndPort("192.169.1.68", 7003));
        nodes.add(new HostAndPort("192.169.1.68", 7004));
        nodes.add(new HostAndPort("192.169.1.68", 7005));
        nodes.add(new HostAndPort("192.169.1.68", 7006));
        JedisCluster cluster = new JedisCluster(nodes);
        String result = cluster.lpop("testList");
        System.out.println(result);
        return result;*/

//        iStudentService.testSetterDi();
        Object paginationInterceptor = applicationContext.getBean("paginationInterceptor");
        ISysuserService iSysuserService = applicationContext.getBean("sysuserServiceImpl_Two", ISysuserService.class);
        iStudentService.getAllStudent();
        return "true";
    }
    
    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.176:6379").setPassword("123456").setTimeout(3310000).setConnectTimeout(3330000);
        RedissonClient redissonClient = Redisson.create(config);
        RLock rLock = redissonClient.getLock("lock1");
        
        boolean b;
        try {
            if (!rLock.tryLock(100, TimeUnit.SECONDS)){
                return "请稍等，正在处理";
            }
            b = sysuserService.save(sysuser);
            Thread.sleep(3000);
            rLock.unlock();
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/

    public static void main(String[] args) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.3.176:6379").setPassword("123456");
        RedissonClient redissonClient = Redisson.create(config);
        RLock rLock = redissonClient.getLock("lock1");
        rLock.lock();
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


    /*@PostMapping("/addSysuser")
    public String addSysuser(@RequestBody Sysuser sysuser) {
        
        boolean b;
        try {
            b = sysuserService.insertUnique(sysuser);
        } catch (Exception e) {
            logger.error("插入报错了", e);
            return "插入报错了";
        }
        return b ? "插入成功" : "插入失败";
    }*/

}
