package com.example.demo.mapper;

import com.example.demo.bean.Sysuser;
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
}
