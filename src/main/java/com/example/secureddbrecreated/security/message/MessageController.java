package com.example.secureddbrecreated.security.message;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="chat")
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {this.messageService = messageService;}

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getMessages();
    }

    @PostMapping
    public void sendMessage(@RequestBody Message message) {
        messageService.addNewMessage(message);
    }

    @DeleteMapping(path = "{messageId}")
    public void deleteMessage(@PathVariable("messageId") Long messageId) {
        messageService.deleteMessage(messageId);
    }

    @PutMapping(path = "{messageId}")
    public void updateMessage(@PathVariable("messageId") Long messageId, @RequestBody Message messageDetails) {
        messageService.updateMessage(messageId, messageDetails);
    }
}
