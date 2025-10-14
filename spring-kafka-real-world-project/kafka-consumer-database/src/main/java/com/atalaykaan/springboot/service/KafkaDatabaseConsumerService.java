package com.atalaykaan.springboot.service;

import com.atalaykaan.springboot.entity.WikimediaData;
import com.atalaykaan.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaDatabaseConsumerService.class);

    private WikimediaDataRepository wikimediaDataRepository;

    public KafkaDatabaseConsumerService(WikimediaDataRepository wikimediaDataRepository) {

        this.wikimediaDataRepository = wikimediaDataRepository;
    }

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String eventMessage) {

        logger.info("Received event message: {}", eventMessage);

        WikimediaData wikimediaData = new WikimediaData();

        wikimediaData.setWikiEventData(eventMessage);

        wikimediaDataRepository.save(wikimediaData);
    }
}
