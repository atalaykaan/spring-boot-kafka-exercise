//package com.atalaykaan.springboot;
//
//import com.launchdarkly.eventsource.MessageEvent;
//import com.launchdarkly.eventsource.background.BackgroundEventHandler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//
//public class WikimediaChangeHandler implements BackgroundEventHandler {
//
//    private final Logger logger = LoggerFactory.getLogger(WikimediaChangeHandler.class);
//
//    private final KafkaTemplate<String, String> kafkaTemplate;
//
//    private String topic;
//
//    public WikimediaChangeHandler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
//
//        this.kafkaTemplate = kafkaTemplate;
//
//        this.topic = topic;
//    }
//
//    @Override
//    public void onOpen() throws Exception {
//
//        logger.info("onOpen()");
//
//    }
//
//    @Override
//    public void onClosed() throws Exception {
//
//        logger.info("onClosed()");
//
//    }
//
//    @Override
//    public void onMessage(String s, MessageEvent messageEvent) throws Exception {
//
//        logger.info("Event data: {}", messageEvent.getData());
//
//        kafkaTemplate.send(topic, messageEvent.getData());
//
//    }
//
//    @Override
//    public void onComment(String s) throws Exception {
//
//    }
//
//    @Override
//    public void onError(Throwable throwable) {
//
//        logger.info("onError()");
//
//    }
//}
