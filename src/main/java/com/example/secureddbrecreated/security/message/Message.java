package com.example.secureddbrecreated.security.message;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalTime;

@Entity
@Table
@Setter
@Getter
@ToString
public class Message {

    @Id
    @SequenceGenerator(
            name = "message_sequence",
            sequenceName = "message_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "message_sequence"
    )
    private Long messageId;
    private String username;
    private String text;
    private LocalTime time;

    public Message() {}

    public Message(Long messageId, String username, String text, LocalTime time) {
        this.messageId = messageId;
        this.username = username;
        this.text = text;
        this.time = time;

    }
    public Message(String username, String text, LocalTime time) {
        this.username = username;
        this.text = text;
        this.time = time;
    }
}
