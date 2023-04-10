package com.alexshabetia.samples.avro;

import com.alexshabetia.samples.kafka.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AvroProducer {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(final String topic, final User message) {
        log.info("Producing message [{}]", message);

        kafkaTemplate.send(topic, message);
    }

}
