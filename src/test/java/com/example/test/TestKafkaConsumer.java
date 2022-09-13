package com.example.test;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 应用模块名称
 *
 * @author zhousy
 * @date 2021-10-25  10:41
 */
public class TestKafkaConsumer {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.3.176:9092");
            properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "timingConsumer");
            properties.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "false");
            
            
            KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(properties);
            kafkaConsumer.subscribe(Collections.singletonList("topic3"));
            ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofSeconds(1));
            System.out.println(records.count());
            /*Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();
            offsets.put(new TopicPartition("topic3",0), new OffsetAndMetadata(5));
            kafkaConsumer.commitSync(offsets);*/
            kafkaConsumer.commitSync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
