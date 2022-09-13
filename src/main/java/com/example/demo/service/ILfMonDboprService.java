package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.bean.LfMonDbopr;
import com.example.demo.bean.Sysuser;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
public interface ILfMonDboprService extends IService<LfMonDbopr> {
    
    int updateRealTime(int proceNode) throws Exception;

    void test();
}
