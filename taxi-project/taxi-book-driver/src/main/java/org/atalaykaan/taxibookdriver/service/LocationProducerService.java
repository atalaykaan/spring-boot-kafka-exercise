package org.atalaykaan.taxibookdriver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atalaykaan.taxibookdriver.dto.LocationResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LocationProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.producer.topic}")
    private String topic;

    public LocationResponseDto sendMessage() {

        String location = Math.random() + ", " + Math.random();

        kafkaTemplate.send(topic, location);

        log.info("Message sent: {}", location);

        return LocationResponseDto.builder()
                .location(location)
                .build();
    }
}
