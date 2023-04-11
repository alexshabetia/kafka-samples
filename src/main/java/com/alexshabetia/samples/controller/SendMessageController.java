package com.alexshabetia.samples.controller;

import com.alexshabetia.samples.kafka.Producer;
import com.alexshabetia.samples.kafka.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.vladkrava.converter.http.AbstractAvroHttpMessageConverter.AVRO_JSON;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final Producer producer;
    @Value("${app.topic}")
    private String topic;

    @PostMapping(value = "/send", produces = AVRO_JSON, consumes = AVRO_JSON)
    public ResponseEntity<User> send(@RequestBody User user) {

        producer.send(topic, user);

        return ResponseEntity.ok(user);
    }
}
