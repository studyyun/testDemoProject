package com.example.demo.config;

import com.example.demo.kafka.consumer.ConsumerCustomInterceptors;
import com.example.demo.kafka.producer.CustomizeInterceptors;
import com.example.demo.kafka.producer.CustomizeInterceptorsTwo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaConsumerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.DefaultKafkaProducerFactoryCustomizer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.ProducerFactory;

import java.util.Map;

@Configuration
//@Component
public class KafkaConfig{

    private final KafkaProperties properties;

    public KafkaConfig(KafkaProperties properties) {
        this.properties = properties;
    }


    @Bean
    @ConditionalOnMissingBean(ProducerFactory.class)
    public ProducerFactory<?, ?> kafkaProducerFactory(
            ObjectProvider<DefaultKafkaProducerFactoryCustomizer> customizers) {
        Map<String, Object> map = this.properties.buildProducerProperties();
        //生产者拦截器
//        map.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, CustomizeInterceptors.class.getName() + "," + CustomizeInterceptorsTwo.class.getName());
        DefaultKafkaProducerFactory<?, ?> factory = new DefaultKafkaProducerFactory<>(
                map);
        String transactionIdPrefix = this.properties.getProducer().getTransactionIdPrefix();
        if (transactionIdPrefix != null) {
            factory.setTransactionIdPrefix(transactionIdPrefix);
        }
        customizers.orderedStream().forEach((customizer) -> customizer.customize(factory));
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean(ConsumerFactory.class)
    public ConsumerFactory<?, ?> kafkaConsumerFactory(
            ObjectProvider<DefaultKafkaConsumerFactoryCustomizer> customizers) {
        Map<String, Object> map = this.properties.buildConsumerProperties();
        map.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG, ConsumerCustomInterceptors.class.getName());
//        map.put(ConsumerConfig.FETCH_MAX_BYTES_CONFIG, 1);
        DefaultKafkaConsumerFactory<Object, Object> factory = new DefaultKafkaConsumerFactory<>(
                map);
        customizers.orderedStream().forEach((customizer) -> customizer.customize(factory));
        return factory;
    }
    
    


    /*public void run(String... args) throws Exception {
        HashMap<String, Object> newMap = new HashMap<>(kafkaProducerFactory.getConfigurationProperties());
        newMap.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, CustomizeInterceptors.class.getName());
        kafkaProducerFactory.updateConfigs(newMap);
    }*/
}
