package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.LfMonDbopr;
import com.example.demo.mapper.LfMonDboprMapper;
import com.example.demo.service.ILfMonDboprService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-08-13  14:43
 */
@Service
public class LfMonDboprServiceImpl extends ServiceImpl<LfMonDboprMapper, LfMonDbopr> implements ILfMonDboprService {

    private final LfMonDboprMapper lfMonDboprMapper;

    public LfMonDboprServiceImpl(LfMonDboprMapper lfMonDboprMapper) {
        this.lfMonDboprMapper = lfMonDboprMapper;
    }

    @Override
    public int updateRealTime(int proceNode) {
        try {
            while (true) {
                int maxId = lfMonDboprMapper.selectVersion();
                int count = lfMonDboprMapper.updateRealTime(proceNode, maxId);
                if (count > 0) {
                    return count;
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            log.error("异常了", e);
            return 0;
        }

    }

    @Override
    public void test() {
        int i = lfMonDboprMapper.selectVersion();
        int i1 = 0;
    }
}
