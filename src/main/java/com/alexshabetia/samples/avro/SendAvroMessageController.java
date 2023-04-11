package com.alexshabetia.samples.avro;

import com.alexshabetia.samples.kafka.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendAvroMessageController {

    @Autowired
    private final AvroProducer producer;

    @GetMapping("/send1")
    public ResponseEntity<User> getLocationByUuid() {
        var userMessage = User.newBuilder()
                .setName("Jonh")
                .setAge(33)
                .build();
        var topic = "user";

        producer.send(topic, userMessage);

        return ResponseEntity.ok(userMessage);
    }
}
