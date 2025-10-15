package com.atalaykaan.spring_boot_kafka_exercise_2.controller;

import com.atalaykaan.spring_boot_kafka_exercise_2.dto.MessageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    private KafkaTemplate<String, String> kafkaTemplate;

    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<MessageRequest> publishMessage(@RequestBody MessageRequest messageRequest) {

        kafkaTemplate.send("atalaykaan", messageRequest.message());

        return ResponseEntity.status(HttpStatus.CREATED).body(messageRequest);
    }
}
