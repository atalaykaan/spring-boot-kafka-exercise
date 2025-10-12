package com.atalaykaan.spring_boot_kafka_exercise.kafka;

import com.atalaykaan.spring_boot_kafka_exercise.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumerService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics = "exampleTopic_json", groupId = "myGroup")
    public void consume(User message) {

        logger.info("Received message: {}", message);
    }
}
