package com.example.secureddbrecreated.security.message;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    public void addNewMessage(Message message) {
        message.setTime(LocalTime.now());

        messageRepository.save(message);

    }

    public void deleteMessage(Long messageId) {
        boolean existence = messageRepository.existsById(messageId);

        if (!existence) {
            throw new IllegalStateException("the message with id " + messageId + " does not exist");
        }
        messageRepository.deleteById(messageId);
    }

    @Transactional
    public void updateMessage(Long messageId, Message messageDetails) {

        Message updateMessage = messageRepository.findById(messageId)
                .orElseThrow(()-> new IllegalStateException("the message with id " + messageId + " does not exist"));

        updateMessage.setText(messageDetails.getText());
        updateMessage.setUsername(messageDetails.getUsername());
        updateMessage.setTime(LocalTime.now());

        messageRepository.save(updateMessage);
    }
}
