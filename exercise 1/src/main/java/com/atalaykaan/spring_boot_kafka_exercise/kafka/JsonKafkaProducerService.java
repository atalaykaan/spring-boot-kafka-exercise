package com.atalaykaan.spring_boot_kafka_exercise.kafka;

import com.atalaykaan.spring_boot_kafka_exercise.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducerService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private KafkaTemplate<String, User> kafkaTemplate;

    public JsonKafkaProducerService(KafkaTemplate<String, User> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(User data) {

        logger.info("Message sent: {}", data.toString());

        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC, "exampleTopic_json")
                .build();

        kafkaTemplate.send(message);
    }
}
