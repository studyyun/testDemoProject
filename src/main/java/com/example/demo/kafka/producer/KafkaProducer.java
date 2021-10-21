package com.example.demo.kafka.producer;


import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.lang.NonNull;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String topic) {
//        System.out.println(new Date());
        /*for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("topic1", i+"");
        }*/
//        kafkaTemplate.send("topic1", normalMessage);
        try {
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, "你好不好，我不好，哈喽baby");
            future.addCallback((result)->{
//                System.out.println("发送成功" + result.toString());
            }, (ex) ->{
                System.out.println("发送失败");
                ex.printStackTrace();
            });
        } catch (Exception e) {
            System.out.println("同步发送报错了");
            e.printStackTrace();
        }
    }

    // 发送过期消息
    @GetMapping("/kafka/timeout/{num}")
    public void sendMessage3(@PathVariable("num") Integer num) {
        System.out.println(new Date());
        /*for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("topic1", i+"");
        }*/
//        kafkaTemplate.send("topic1", normalMessage);
        try {
            ProducerRecord<String, Object> producerRecord = new ProducerRecord<>("topic3", null, System.currentTimeMillis() - num * 1000, null, "nihao");
            ListenableFuture<SendResult<String, Object>> future = kafkaTemplate.send(producerRecord);
            future.addCallback((result)->{
                System.out.println("发送成功" + result.toString());
            }, (ex) ->{
                System.out.println("发送失败");
                ex.printStackTrace();
            });
        } catch (Exception e) {
            System.out.println("同步发送报错了");
            e.printStackTrace();
        }
    }

    // 发送消息
    @GetMapping("/kafka/callback/{message}")
    public void sendMessage2(@NonNull@PathVariable("message") String callbackMsg) {
        kafkaTemplate.send("topic2", callbackMsg).addCallback(success -> {
            System.out.println("成功" + success);
        }, fail -> {
            System.out.println("失败" + fail);
        });
        kafkaTemplate.send("topic1", callbackMsg).addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
            @Override
            public void onFailure(@NonNull Throwable ex) {
                System.out.println(ex.getMessage());
            }

            @Override
            public void onSuccess(SendResult<String, Object> result) {
                System.out.println(result.getProducerRecord().toString());
                System.out.println(result.getRecordMetadata().toString());
            }
        });
    }

    @PostMapping("/test123")
    public void testNo(@lombok.NonNull String name) {
        System.out.println(name);
    }

    @GetMapping("/kafka/transaction")
    public void transaction() {
        /*kafkaTemplate.executeInTransaction(operations -> {
            operations.send("topic1","事务发送");
            throw new RuntimeException();
        });*/

        kafkaTemplate.send("topic1","非事务发送");
        throw new RuntimeException();
    }

}
