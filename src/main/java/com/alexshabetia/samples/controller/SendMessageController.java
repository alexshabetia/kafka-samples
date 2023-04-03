package com.alexshabetia.samples.controller;

import com.alexshabetia.samples.kafka.Models;
import com.alexshabetia.samples.kafka.Producer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMessageController {

    @Autowired
    private final Producer producer;

    @GetMapping("/send")
    public ResponseEntity<Models.User> getLocationByUuid() {
        var userMessage = Models.User.newBuilder()
                .setName("Jonh")
                .setAge(33)
                .build();
        var topic = "user";

        producer.send(topic, userMessage);

        return ResponseEntity.ok(userMessage);
    }
}
