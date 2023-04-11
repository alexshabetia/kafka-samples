package com.alexshabetia.samples.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(final String topic, final User message) {
        log.info("Producing message [{}]", message);

        kafkaTemplate.send(topic, message);
    }
}
