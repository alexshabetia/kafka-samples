package com.alexshabetia.samples.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UsersStream {

    @Value("${app.topic}")
    private String usersTopicName;

    @Bean
    public KStream<String, User> handleUsersStream(StreamsBuilder builder) {
        KStream<String, User> userStream = builder.stream(usersTopicName);
        userStream.foreach((k, v) -> log.info(String.valueOf(v)));
        return userStream;
    }
}
