package com.alexshabetia.samples.avro;

import com.alexshabetia.samples.kafka.Models;
import com.alexshabetia.samples.kafka.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

@Slf4j
@Service
public class AvroConsumer {

    private CountDownLatch latch = new CountDownLatch(1);
    private User payload = null;

    @KafkaListener(topics = "${app.topic}")
    public void consume(User message) throws IOException {
        latch.countDown();

        log.info("Consumed message [{}]", message);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

    public User getPayload() {
        return payload;
    }
}
