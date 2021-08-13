package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.bean.LfMonDbopr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-03-23
 */
@Repository
public interface LfMonDboprMapper extends BaseMapper<LfMonDbopr> {

    int updateRealTime(@Param("proceNode") int proceNode, @Param("version") int version);

    int selectVersion();
}
