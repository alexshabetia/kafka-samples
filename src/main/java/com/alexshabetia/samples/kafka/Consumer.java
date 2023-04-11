package com.alexshabetia.samples.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Service
public class Consumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private User payload = null;

    @KafkaListener(topics = "${app.topic}")
    public void consume(User message) {
        latch.countDown();
        payload = message;
        log.info("Consumed message [{}]", message);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public User getPayload() {
        return payload;
    }
}
