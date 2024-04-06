package com.takarub.Kafka.consumer;

import com.takarub.Kafka.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    //@KafkaListener(topics = "test7788",groupId = "myGroup")

    public void consumeMsg(String msg){
        log.info(String.format("Consuming message form test7788 Topic:: %s",msg));
    }

    @KafkaListener(topics = "test7788",groupId = "myGroup")
    public void consumeJosnMsg(Student student){
        log.info(String.format("Consuming message form test7788 Topic:: %s",student.toString()));

    }
}
