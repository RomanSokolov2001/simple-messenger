package com.example.secureddbrecreated.security.message;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;
import java.util.List;

@Configuration
public class MessageConfig {

    @Bean
    CommandLineRunner commandLineRunner(MessageRepository messageRepository) {
        return args -> {
            Message msg1 = new Message("user", "hello", LocalTime.now());
            messageRepository.saveAll(List.of(msg1, msg1));
        };
    }
}
