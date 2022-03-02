package com.lixnlearn.support.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lixn
 * @date 2022/03/02 14:31
 **/
@RestController
public class KafkaTestController {

    @Autowired
    private UserLogProducer userLogProducer;

    @GetMapping("/kafka/insert")
    public String insert(String userId) {
        userLogProducer.send(userId);
        return null;
    }

}
