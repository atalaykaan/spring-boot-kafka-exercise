package com.atalaykaan.spring_boot_kafka_exercise.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "exampleTopic", groupId = "myGroup")
    public void consumer(String message) {

        logger.info("Received message: {}", message);
    }
}
