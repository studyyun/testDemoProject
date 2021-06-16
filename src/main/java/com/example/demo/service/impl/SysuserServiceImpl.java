package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.Student;
import com.example.demo.bean.Sysuser;
import com.example.demo.mapper.SysuserMapper;
import com.example.demo.service.ISysuserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
@Service
@Transactional
public class SysuserServiceImpl extends ServiceImpl<SysuserMapper, Sysuser> implements ISysuserService {

    private static final Logger logger = LoggerFactory.getLogger(SysuserServiceImpl.class);

    private final SysuserMapper sysuserMapper;

    public SysuserServiceImpl(SysuserMapper sysuserMapper) {
        this.sysuserMapper = sysuserMapper;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addSysuserSyncUIM() throws Exception {
//        try {
            Sysuser sysuser = new Sysuser().setId(1).setUserName("111");
            sysuserMapper.updateById(sysuser);
//            int i = 1/0;
            throw new IOException("222");
        /*int[] ints = new int[2];
        ints[3] = 2;*/
        /*} catch (Exception e) {
            logger.error("UIM用户添加接口失败", e);
//            throw new RuntimeException("UIM用户查询同步接口失败");
            throw new Exception("UIM用户创建同步失败");
        }*/
//        return true;
    }

    @Override
    public List<Sysuser> testOrderby() {
        Page<Sysuser> page = new Page<>();
        List<Sysuser> list1 = sysuserMapper.testOrderby(page);
        page.setSize(10);
        page.setCurrent(2);
        List<Sysuser> list2 = sysuserMapper.testOrderby(page);
        int i = 0;
        return sysuserMapper.testOrderby(page);
    }

}
