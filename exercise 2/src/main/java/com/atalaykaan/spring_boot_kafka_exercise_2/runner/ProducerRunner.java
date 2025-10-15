package com.atalaykaan.spring_boot_kafka_exercise_2.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProducerRunner implements CommandLineRunner {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerRunner(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void run(String[] args) {

        for (int i = 0; i < 100; i++) {
            kafkaTemplate.send("atalaykaan", "hello Kafka " + i);
        }
    }
}
