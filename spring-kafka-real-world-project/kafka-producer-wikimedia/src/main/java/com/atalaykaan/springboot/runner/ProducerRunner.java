package com.atalaykaan.springboot.runner;

import com.atalaykaan.springboot.service.WikimediaChangeProducerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProducerRunner implements CommandLineRunner {

    private final WikimediaChangeProducerService wikimediaChangeProducerService;

    public ProducerRunner(WikimediaChangeProducerService wikimediaChangeProducerService) {

        this.wikimediaChangeProducerService = wikimediaChangeProducerService;
    }

    @Override
    public void run(String[] args) throws Exception {
        wikimediaChangeProducerService.sendMessage();
    }
}
