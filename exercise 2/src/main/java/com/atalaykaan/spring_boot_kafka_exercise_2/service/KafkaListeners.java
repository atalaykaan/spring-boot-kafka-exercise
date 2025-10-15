package com.atalaykaan.spring_boot_kafka_exercise_2.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaListeners {

    private final Logger logger = LoggerFactory.getLogger(KafkaListeners.class);

    @KafkaListener(topics = "atalaykaan", groupId = "exampleGroup")
    public void listener(String message) {

        logger.info("Received listener: {}", message);
    }
}
