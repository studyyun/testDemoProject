/*
package com.example.demo.kafka.consumer;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.checkerframework.checker.units.qual.K;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.ConcurrentKafkaListenerContainerFactoryConfigurer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class KafkaConsumerService {

    private final ConsumerFactory consumerFactory;

    private final KafkaProperties properties;

    private ThreadPoolExecutor threadPool =
            new ThreadPoolExecutor(6, 8, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<>(1024), new ThreadPoolExecutor.CallerRunsPolicy());

    public KafkaConsumerService(ConsumerFactory consumerFactory, KafkaProperties properties) {
        this.consumerFactory = consumerFactory;
        this.properties = properties;
    }

    @Bean
    public ConsumerAwareListenerErrorHandler consumerAwareListenerErrorHandler() {
        return (message, exception, consumer) -> {
            System.out.println(message);
            exception.printStackTrace();
            System.out.println(consumer);
            System.out.println("报异常啦！！！！");
            return null;
        };
    }

    @Bean
//    @ConditionalOnMissingBean(name = "kafkaListenerContainerFactory")
    ConcurrentKafkaListenerContainerFactory filterContainerFactory(
            ConcurrentKafkaListenerContainerFactoryConfigurer configurer,
            ObjectProvider<ConsumerFactory<Object, Object>> kafkaConsumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setAckDiscarded(true);
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        factory.getContainerProperties().setSyncCommits(false);
        factory.setBatchListener(true);
*/
/*containerFactory.setRecordFilterStrategy(consumerRecord ->{
            if (Integer.valueOf(consumerRecord.value().toString()) % 2 == 0) {
                System.out.println("被丢弃" + consumerRecord.value().toString());
                return true;
            }else {
                System.out.println("被保留" + consumerRecord.value().toString());
                return false;
            }
        });*//*

*/
/*configurer.configure(factory, kafkaConsumerFactory
                .getIfAvailable(() -> new DefaultKafkaConsumerFactory<>(this.properties.buildConsumerProperties())));*//*
*/
/*
         *//*

        return factory;

    }


*/
/*@Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory() {
        ConcurrentKafkaListenerContainerFactory containerFactory = new ConcurrentKafkaListenerContainerFactory();
        containerFactory.setConsumerFactory(consumerFactory);
        containerFactory.setAckDiscarded(true);
//        containerFactory.setBatchListener(true);
        containerFactory.setRecordFilterStrategy(consumerRecord ->{
            if (Integer.valueOf(consumerRecord.value().toString()) % 2 == 0) {
                System.out.println("被丢弃" + consumerRecord.value().toString());
                return true;
            }else {
                System.out.println("被保留" + consumerRecord.value().toString());
                return false;
            }
        });
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(3);
        poolTaskExecutor.setMaxPoolSize(6);
        poolTaskExecutor.setQueueCapacity(1024);
        poolTaskExecutor.initialize();
        containerFactory.getContainerProperties().setConsumerTaskExecutor(poolTaskExecutor);
        return containerFactory;
    }*//*



    @KafkaListener(groupId = "timingConsumer",topics = {"topic3","topic2"},containerFactory = "filterContainerFactory")
    public void onMessage(List<ConsumerRecord> recordList, Acknowledgment ack, Consumer consumer) {
*/
/*System.out.println("简单消费" + record.toString());
        threadPool.execute(()->{
            System.out.println(Thread.currentThread().getName() + "消费消费");
            if (record.offset() % 2 == 0) {
                System.out.println("偶数提交，offset=" + record.offset());
                ack.acknowledge();
            }
        });*//*



        System.out.println("批量消费" + recordList.size());
        threadPool.execute(()->{
            System.out.println(Thread.currentThread().getName() + "消费消费");
            if (recordList.get(recordList.size()-1).offset() % 2 == 0) {
                System.out.println("偶数提交，offset=" + recordList.get(recordList.size()-1));
                ack.acknowledge();
            }
        });
        
    }
    
    
*/
/*@KafkaListener(id = "consumer111", groupId = "felix-group", topicPartitions = {
            @TopicPartition(topic = "topic1", partitions = { "0" }),
//            @TopicPartition(topic = "topic2", partitions = "0", partitionOffsets = @PartitionOffset(partition = "1", initialOffset = "8"))
    })
    public void onMessage2(ConsumerRecord<?,?> record) {
        System.out.println("简单消费" + record);
    }*//*
*/
/*




     *//*

*/
/*@KafkaListener(topics = {"topic1","topic2"}, errorHandler = "consumerAwareListenerErrorHandler")
    public void onMessage3(List<ConsumerRecord<?,?>> recordList) throws Exception{
        System.out.println(new Date() + "批量消费" + recordList.size());
//        throw new Exception("测试异常抓取");
    }*//*
*/
/*


     *//*

*/
/*@KafkaListener(topics = {"topic1"}, errorHandler = "consumerAwareListenerErrorHandler")
    @SendTo("topic2")
    public String onMessage4(ConsumerRecord<?, ?> record) {
        System.out.println("简单消费" + record.value().toString());
        return record.value().toString() + "forward message";
    }

    @KafkaListener(topics = {"topic2"}, errorHandler = "consumerAwareListenerErrorHandler")
    public void onMessage5(ConsumerRecord<?, ?> record) {
        System.out.println(record.value().toString());
    }*//*
*/
/*


}
*//*

}
*/
