/*
package com.example.demo.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Date;

*/
/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-10-20  11:01
 *//*

@Component
public class MonitorKafkaConsumer {

    @KafkaListener(id = "monitor-consumer", topics = "topic-monitor")
    public void getMonitor(ConsumerRecord consumerRecord) {
        String s = consumerRecord.value().toString();
        System.out.println(new Date() + "--接收到监控消息：" + s);
    }
    
}
*/
