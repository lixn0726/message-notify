package com.lixnlearn.support.kafka;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author lixn
 * @date 2022/03/02 14:19
 **/
@Component
@Slf4j
public class UserLogConsumer {

    @KafkaListener(topics = {"lixn"}, groupId = "lixnGroup1")
    public void consume(ConsumerRecord<?, ?> consumerRecord) {
        Optional<?> kafkaMessage = Optional.ofNullable(consumerRecord.value());
        log.info(">>>>>>>>>> record = " + kafkaMessage);
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.err.println("消费消息: " + message);
        }
    }

}
