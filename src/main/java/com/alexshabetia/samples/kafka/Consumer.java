//package com.alexshabetia.samples.kafka;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.concurrent.CountDownLatch;
//
//@Slf4j
//@Service
//public class Consumer {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//    private Models.User payload = null;
//
//    @KafkaListener(topics = "${app.topic}")
//    public void consume(byte[] message) throws IOException {
//        latch.countDown();
//        payload = Models.User.parseFrom(message);
//
//        log.info("Consumed message [{}]", payload);
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//    public Models.User getPayload() {
//        return payload;
//    }
//}
