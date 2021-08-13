package com.example.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.serializer.SerializeConfig;

import java.util.concurrent.TimeUnit;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-05-10  10:03
 */
public class TestMetaSpace {

    /**
     * 返回Json字符串.驼峰转_
     * @param bean 实体类.
     */
    public static String buildData(Object bean) {
        try {
            SerializeConfig CONFIG = new SerializeConfig();
            CONFIG.propertyNamingStrategy = PropertyNamingStrategy.SnakeCase;
            return JSON.toJSONString(bean, CONFIG);
        } catch (Exception e) {
            return null;
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 50_000_000; i++) {
            /*if (i % 10_000_000 == 0){
                TimeUnit.SECONDS.sleep(5);
            }*/
            TestMetaSpace.buildData(new TestHttp());
//            TimeUnit.MILLISECONDS.sleep(10);
        }
        
        TimeUnit.SECONDS.sleep(160);
        
    }
    
}
