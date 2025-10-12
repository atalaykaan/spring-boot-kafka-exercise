package com.atalaykaan.spring_boot_kafka_exercise.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {

        logger.info("Message sent: {}", message);

        kafkaTemplate.send("exampleTopic", message);
    }
}
