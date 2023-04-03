package com.alexshabetia.samples.kafka;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Producer {

//    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void send(final String topic, final Models.User message) {
        log.info("Producing message [{}]", message);

        kafkaTemplate.send(topic, message.toByteArray());
    }
}