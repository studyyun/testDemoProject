package com.example.demo.mapper;

import com.example.demo.bean.Child;
import com.example.demo.bean.SanwInfo;
import com.example.demo.bean.Sysuser;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.session.ResultHandler;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-09-15  17:09
 */
@Repository
public interface TestMapper {
    List<Sysuser> getStudentName();
    
    Integer getId();

    /**
     * 调用存储过程进行短信扣费
     */
    @Select({ "CALL PROC_FEEZSZQ(#{PTYPE,mode=IN,jdbcType=INTEGER})" })
    @Options(statementType= StatementType.CALLABLE)
    void deduction(@Param(value = "PTYPE") Integer i);

    void runProcFeeZszq();

    void testParent(@Param("child") Child child);
    
    List<SanwInfo> testQueryTime();

    @Select("${sql}")
    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 2000)
    @ResultType(SanwInfo.class)
    void dynamicSelectLargeData1(@Param("sql") String sql, ResultHandler<SanwInfo> handler);

//    @Options(resultSetType = ResultSetType.FORWARD_ONLY, fetchSize = 1000)
    void dynamicSelectLargeData2(ResultHandler<SanwInfo> handler);

}
