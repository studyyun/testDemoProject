package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.Student;

import javax.inject.Named;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-22
 */
@Named
public interface StudentMapper extends BaseMapper<Student> {

    List<Student> findAllUser();

    Student findOtherUser(String id);

}
