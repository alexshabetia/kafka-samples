package com.alexshabetia.samples.controller;

import com.alexshabetia.samples.kafka.Producer;
import com.alexshabetia.samples.kafka.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.vladkrava.converter.http.AbstractAvroHttpMessageConverter.AVRO_JSON;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    private final Producer producer;

    @GetMapping("/send")
    public ResponseEntity<User> send() {
        var userMessage = User.newBuilder()
                .setName("Jonh")
                .setAge(33)
                .build();
        var topic = "user";

        producer.send(topic, userMessage);

        return ResponseEntity.ok(userMessage);
    }

    @PostMapping(value = "/send", produces = AVRO_JSON, consumes = AVRO_JSON)
    public ResponseEntity<User> send(@RequestBody User user) {
        var topic = "user";

        producer.send(topic, user);

        return ResponseEntity.ok(user);
    }
}
