package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.Student;
import com.example.demo.bean.Sysuser;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.SysuserMapper;
import com.example.demo.service.IStudentService;
import com.example.demo.service.ISysuserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
//@Slf4j
@Service
@Transactional
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    private final StudentMapper studentMapper;

    private ISysuserService iSysuserService;

    private final SysuserMapper sysuserMapper;
    
    @Autowired
    public void setiSysuserService(@Qualifier("sysuserServiceImpl") ISysuserService iSysuserService){
        this.iSysuserService = iSysuserService;
    }
    
    public StudentServiceImpl(StudentMapper studentMapper, SysuserMapper sysuserMapper) {
        this.studentMapper = studentMapper;
        this.sysuserMapper = sysuserMapper;
    }


    @Override
    public List<Student> getAllStudent() {
        return studentMapper.findAllUser();
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
//    @Transactional(rollbackFor = NullPointerException.class)
    public void testTransactional() throws Exception {
//        logger.info("测试测试哈哈哈哈");
        logger.info("测试测试哈哈哈哈");
        delEmployee();
        syncUIMSearch();
        add();
//        int i = 1/0;
    }

    @Override
    public void testSetterDi() {
        iSysuserService.testSetDI();
    }

    public void delEmployee(){
        Student student = new Student().setId(1).setAddress("123").setAge(10).setName("111");
        studentMapper.updateById(student);
    }

//    @Transactional(rollbackFor = NullPointerException.class)
    private void syncUIMSearch(){
        try {
            Student student = new Student().setId(1).setAddress("123").setAge(10).setName("222");
            studentMapper.updateById(student);
//            throw new IOException("222");
            /*int[] ints = new int[2];
            ints[3] = 2;*/
        } catch (Exception e) {
            logger.error("UIM用户查询同步接口失败", e);
            throw new RuntimeException("UIM用户查询同步接口失败");
        }
//        int i = 1/0;
    }

    @Transactional(rollbackFor = Exception.class)
    public void add() throws Exception {
        Student student = new Student().setId(1).setAddress("123").setAge(10).setName("333");
        studentMapper.updateById(student);
        logger.info("执行到test2");

        //spring的@Transactional 可以注解到方法上或者类上 并且只有在 该类被作为spring容器托管的bean的时候
        // 也就是使用@autowird 被注入到其他类中使用 调用该类的方法的时候才生效 因为此时调用方法会被spring容器的 TransactionInterceptor 拦截器拦截 并开启事务
        // 如果是同一个类中的方法 调用 第二个方法 即this.方法 ，第二个方法的事务 是不起作用的 所以这就是为啥第一种情况没有 mark-as roll异常
        // 第二中情况的异常 是因为 使用默认的@Transactional 注解 事物的传播性默认为Propagation.REQUIRED 调用其他类的 事务方法 personService.addPerson(user);
        // 这个方法开启的事务是默认Propagation.REQUIRED 也就是沿用外层调用方法的事务 （如果有事务存在 则使用原事务 如果不存在则开启新事务）
        // 外层方法开启了一个事务 内层方法调用的是其他类的事务方法 内层方法发现异常了 会标记整个事务为roll-back
        // 但是外层方法捕获异常 return的时候 会执行commit事务 但是此时发现已经标记异常 所以才会出错

//        iSysuserService.addSysuserSyncUIM();
        addSysuserSyncUIM();
        /*try {
        } catch (Exception e) {
            logger.error("远程调用addSysuserSyncUIM方法报错",e);
            throw new RuntimeException("远程调用addSysuserSyncUIM方法报错");
        }*/
//        throw new RuntimeException("2222");
    }

    private void addSysuserSyncUIM(){
//        try {
        Sysuser sysuser = new Sysuser().setId(1).setUserName("111");
        sysuserMapper.updateById(sysuser);
//            int i = 1/0;
        throw new RuntimeException("222");
        /*int[] ints = new int[2];
        ints[3] = 2;*/
        /*} catch (Exception e) {
            logger.error("UIM用户添加接口失败", e);
//            throw new RuntimeException("UIM用户查询同步接口失败");
            throw new Exception("UIM用户创建同步失败");
        }*/
//        return true;
    }
    
    


}
