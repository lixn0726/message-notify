package com.lixnlearn.support.kafka;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author lixn
 * @date 2022/03/02 14:16
 **/
@Component
public class UserLogProducer {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String userid) {
        UserLog userLog = new UserLog();
        userLog.setUsername("lixin");
        userLog.setUserid(userid);
        userLog.setState("0");
        System.err.println("发送用户日志数据: " + userLog);
        kafkaTemplate.send("lixn", JSON.toJSONString(userLog));
    }

}
