/*
package com.example.demo.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

//@EnableScheduling
@Component
public class KafkaTimer {

    @Autowired
    private KafkaListenerEndpointRegistry registry;

    @Autowired
    private ConsumerFactory consumerFactory;

    @Bean
    public ConcurrentKafkaListenerContainerFactory containerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(consumerFactory);
        ContainerProperties containerProperties = containerFactory.getContainerProperties();
        containerProperties.setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        containerFactory.setBatchListener(true);
        //设置消费者监听器不自动启动，默认会自动启动
//        containerFactory.setAutoStartup(false);
        return containerFactory;
    }

    */
/*@KafkaListener(groupId = "timingConsumer", topics = {"topic1","topic2"})
    public void onMessage(ConsumerRecord consumerRecord, Acknowledgment ack) {
        System.out.println("接收到消息：" + consumerRecord.value().toString());
        ack.acknowledge();
    }*//*


    @KafkaListener(groupId = "timingConsumer", topics = {"topic1", "topic2"}, containerFactory = "containerFactory")
    public void onMessage2(ConsumerRecord consumerRecord, Acknowledgment ack) {
        System.out.println("接收到消息：" + consumerRecord.value().toString());
        ack.acknowledge();
    }

    */
/*@Scheduled(cron = "0 59 11 * * ? ")
    public void start() {
        if (!registry.getListenerContainer("timingConsumer").isRunning()) {
            System.out.println("启动监听器" + new Date());
            registry.getListenerContainer("timingConsumer").start();
        }
    }

    @Scheduled(cron = "0 03 12 * * ? ")
    public void stop() {
        if (registry.getListenerContainer("timingConsumer").isRunning()) {
            System.out.println("停止监听器" + new Date());
            registry.getListenerContainer("timingConsumer").stop();
        }
    }*//*


}
*/
