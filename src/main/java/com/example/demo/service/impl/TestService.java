package com.example.demo.service.impl;

import com.example.demo.bean.Sysuser;
import com.example.demo.mapper.TestMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-06  10:32
 */
//@Named("public")
@Service
public class TestService {

    private final TestMapper testMapper;

    public TestService(TestMapper testMapper) {
        this.testMapper = testMapper;
    }


    public void testDiff() {
        List<Sysuser> sysuserList = testMapper.getStudentName();
        int i = 0;
    }
}
