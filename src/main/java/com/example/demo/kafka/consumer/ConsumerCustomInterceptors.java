package com.example.demo.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.*;
import java.util.stream.Collectors;

public class ConsumerCustomInterceptors implements ConsumerInterceptor<String,String> {
    
    private long gapTime = 10 * 1000;
    
    @Override
    public ConsumerRecords<String,String> onConsume(ConsumerRecords<String,String> records) {
        return records;
        /*System.out.println("消费者拦截器");
        long now = System.currentTimeMillis();
        Set<TopicPartition> partitions = records.partitions();
        Map<TopicPartition, List<ConsumerRecord<String,String>>> map = new HashMap<>(partitions.size() * 4 / 3);
        for (TopicPartition topicPartition : partitions) {
            List<ConsumerRecord<String, String>> newRecords = records.records(topicPartition).stream().filter((record) -> now - record.timestamp() <= gapTime).collect(Collectors.toList());
            map.put(topicPartition, newRecords);
        }
        return new ConsumerRecords<>(map);*/
    }

    @Override
    public void close() {

    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> offsets) {
        System.out.println(new Date() + "消费者拦截器提交位移onCommit()：" + offsets);
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
