package com.atalaykaan.spring_boot_kafka_exercise.controller;

import com.atalaykaan.spring_boot_kafka_exercise.kafka.JsonKafkaProducerService;
import com.atalaykaan.spring_boot_kafka_exercise.payload.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {

    JsonKafkaProducerService jsonKafkaProducerService;

    public JsonMessageController(JsonKafkaProducerService jsonKafkaProducerService) {

        this.jsonKafkaProducerService = jsonKafkaProducerService;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishMessage(@RequestBody User message) {

        jsonKafkaProducerService.sendMessage(message);

        return ResponseEntity.ok("Sent json message to kafka topic");
    }
}
