package com.example.demo.service;

import com.example.demo.bean.Student;
import com.example.demo.bean.Sysuser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
public interface ISysuserService extends IService<Sysuser> {

    boolean addSysuserSyncUIM() throws Exception;

    List<Sysuser> testOrderby();
    
    boolean keepUnique(String userId);

    boolean insertUnique(Sysuser sysuser);
}
