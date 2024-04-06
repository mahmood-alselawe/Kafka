package com.takarub.Kafka.rest;

import com.takarub.Kafka.payload.Student;
import com.takarub.Kafka.producer.KafkaJsonProducer;
import com.takarub.Kafka.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){
        kafkaProducer.sendMessage(message);

        return ResponseEntity.ok("message queued successfully");


    }

    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student student){

        kafkaJsonProducer.sendMessage(student);

        return ResponseEntity.ok("message queued successfully as Json");


    }
}
