package com.atalaykaan.springboot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class WikimediaChangeProducerService {

    private final Logger logger = LoggerFactory.getLogger(WikimediaChangeProducerService.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public WikimediaChangeProducerService(KafkaTemplate<String, String> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() throws InterruptedException {

        WebClient client = WebClient.create("https://stream.wikimedia.org/v2/stream/recentchange");

        Flux<String> wikimediaFlux = client.get()
                .accept(MediaType.TEXT_EVENT_STREAM)
                .retrieve()
                .bodyToFlux(String.class);

        wikimediaFlux.subscribe(event -> kafkaTemplate.send("wikimedia_recentchange", event));
    }

//    public void sendMessage() throws InterruptedException {
//
//        BackgroundEventHandler backgroundEventHandler = new WikimediaChangeHandler(kafkaTemplate, "${spring.kafka.topic.name}");
//
//        String url = "https://stream.wikimedia.org/v2/stream/recentchange";
//
//        BackgroundEventSource.Builder builder = new BackgroundEventSource.Builder(backgroundEventHandler, new EventSource.Builder(URI.create(url)));
//
//        BackgroundEventSource backgroundEventSource = builder.build();
//
//        backgroundEventSource.start();
//
//        TimeUnit.MINUTES.sleep(10);
//
//    }
}
