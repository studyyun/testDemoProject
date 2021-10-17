package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.bean.Sysuser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
@Component
public interface SysuserMapper extends BaseMapper<Sysuser> {

    List<Sysuser> testOrderby(Page<Sysuser> page);

    boolean keepUnique(String userId);

    boolean insertUnique(@Param("sysuser") Sysuser sysuser);
}
