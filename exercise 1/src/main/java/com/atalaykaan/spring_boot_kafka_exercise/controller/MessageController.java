package com.atalaykaan.spring_boot_kafka_exercise.controller;

import com.atalaykaan.spring_boot_kafka_exercise.kafka.KafkaProducerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducerService kafkaProducerService;

    public MessageController(KafkaProducerService kafkaProducerService) {

        this.kafkaProducerService = kafkaProducerService;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestParam("message") String message) {

        kafkaProducerService.sendMessage(message);

        return ResponseEntity.ok("Sent message.");
    }
}
