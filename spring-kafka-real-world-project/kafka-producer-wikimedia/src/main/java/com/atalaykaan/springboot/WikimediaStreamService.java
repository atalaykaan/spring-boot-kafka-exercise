//package com.atalaykaan.springboot;
//
//import okhttp3.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
////@Service
//public class WikimediaStreamService {
//
//    private static final Logger logger = LoggerFactory.getLogger(WikimediaStreamService.class);
//    private final KafkaTemplate<String, String> kafkaTemplate;
//    private final OkHttpClient client = new OkHttpClient();
//
//    private static final String STREAM_URL = "https://stream.wikimedia.org/v2/stream/recentchange";
//    private static final String TOPIC = "wikimedia_recentchange";
//
//    public WikimediaStreamService(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    public void startStream() {
//        new Thread(this::connectAndStream).start();
//    }
//
//    private void connectAndStream() {
//        Request request = new Request.Builder()
//                .url(STREAM_URL)
//                .header("User-Agent", "SpringBootKafkaWikimedia/1.0")
//                .build();
//
//        while (true) {
//            try (Response response = client.newCall(request).execute()) {
//                if (!response.isSuccessful()) {
//                    logger.error("Bağlantı başarısız: {}", response);
//                    Thread.sleep(5000);
//                    continue;
//                }
//
//                try (BufferedReader reader = new BufferedReader(
//                        new InputStreamReader(response.body().byteStream()))) {
//
//                    String line;
//                    while ((line = reader.readLine()) != null) {
//                        if (line.startsWith("data:")) {
//                            String json = line.substring(5).trim();
//                            logger.info("Event data: {}", json);
//                            kafkaTemplate.send(TOPIC, json);
//                        }
//                    }
//                }
//            } catch (Exception e) {
//                logger.error("Wikimedia stream bağlantısı koptu, yeniden denenecek...", e);
//                try {
//                    Thread.sleep(3000);
//                } catch (InterruptedException ignored) {
//                }
//            }
//        }
//    }
//}
