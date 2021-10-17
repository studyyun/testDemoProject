package com.example.demo.kafka.producer;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomizeInterceptorsTwo implements ProducerInterceptor<String, String> {

    private AtomicInteger successInt = new AtomicInteger();
    private AtomicInteger failInt = new AtomicInteger();

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        String newValue = "preFix-2" + record.value();
        return new ProducerRecord<>(record.topic(), record.partition(), record.timestamp(),
                record.key(), newValue, record.headers());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {
        if (exception == null) {
            System.out.println("发送成功22");
            successInt.incrementAndGet();
        } else {
            System.out.println("发送失败22");
            failInt.incrementAndGet();
        }
    }

    @Override
    public void close() {
        System.out.println("自定义拦截器close()22，成功数：" + successInt.get() + "，失败数：" + failInt.get());
    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
