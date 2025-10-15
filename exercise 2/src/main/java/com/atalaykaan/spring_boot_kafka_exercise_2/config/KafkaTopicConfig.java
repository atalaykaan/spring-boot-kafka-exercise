package com.atalaykaan.spring_boot_kafka_exercise_2.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic atalaykaanTopic() {

        return TopicBuilder
                .name("atalaykaan")
                .build();
    }
}
