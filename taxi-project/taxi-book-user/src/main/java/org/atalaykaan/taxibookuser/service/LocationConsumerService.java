package org.atalaykaan.taxibookuser.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class LocationConsumerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics = "${spring.kafka.consumer.topic}", groupId = "${spring.kafka.consumer.group.id}")
    public void listen(String message) {

        log.info("Message received: {}",message);
    }
}
