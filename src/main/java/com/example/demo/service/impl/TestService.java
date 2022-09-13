package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.bean.Child;
import com.example.demo.bean.SanwInfo;
import com.example.demo.bean.Student;
import com.example.demo.bean.Sysuser;
import com.example.demo.mapper.LfMonDboprMapper;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.mapper.TestMapper;
import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    
    private final StudentMapper studentMapper;
    
    private final LfMonDboprMapper monDboprMapper;

    public TestService(TestMapper testMapper, StudentMapper studentMapper, LfMonDboprMapper monDboprMapper) {
        this.testMapper = testMapper;
        this.studentMapper = studentMapper;
        this.monDboprMapper = monDboprMapper;
    }


    public void testDiff() {
        Integer id = testMapper.getId();
        
//        int i1 = monDboprMapper.selectVersion();
//        List<Sysuser> sysuserList = testMapper.getStudentName();
        int i = 0;
    }

    public void testProduce() {
        System.out.println(new Date());
        testMapper.deduction(1);
        testMapper.runProcFeeZszq();
        int i = 0;
    }

    public void testParent() {
        Child child = new Child("ww", 1);
        child.setOrderNo(9999);
        testMapper.testParent(child);
    }

    public void testWrapper() {
        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id");
        List<Student> students = studentMapper.selectList(queryWrapper);
        List<Student> studentsss = studentMapper.selectAllIds();
        int i = 0;
    }

    public void testTime() {
        /*int i = 0;
        long start = System.currentTimeMillis();
        List<SanwInfo> sanwInfos = testMapper.testQueryTime();
        System.out.println(sanwInfos.size());
        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
        sanwInfos.clear();
        sanwInfos = null;
        int j = 0;*/


        int i = 0;
        long start = System.currentTimeMillis();
        System.out.println("开始查询");
        String sql = "SELECT CAPITAL_ACCOUNT,MOBILE,INVEST_DURATION,DISLIKE_TYPE,EVAL_LEVEL FROM TM_CUST_RISK_INFO";
        /*testMapper.dynamicSelectLargeData1(sql, new ResultHandler<SanwInfo>() {
            @Override
            public void handleResult(ResultContext<? extends SanwInfo> resultContext) {
                System.out.println(resultContext.getResultCount());
            }
        });*/

        testMapper.dynamicSelectLargeData2(new ResultHandler<SanwInfo>() {
            @Override
            public void handleResult(ResultContext<? extends SanwInfo> resultContext) {
                System.out.println(resultContext.getResultCount());
            }
        });
        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
        int j = 0;
    }
}
