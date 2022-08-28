package com.example.test;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.text.UnicodeUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.test.bean.DateBean;
import com.example.test.bean.User;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.util.CollectionUtils;
import sun.nio.cs.UnicodeEncoder;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-07-30  17:10
 */
public class Test22 {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.3.176:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        KafkaConsumer kafkaConsumer = new KafkaConsumer(properties);
        if (kafkaConsumer instanceof Consumer) {
            System.out.println(1111);
        }

    }

    private void testStringBuilder(StringBuilder stringBuilder) {
        stringBuilder.append("1123123123");
    }


}
