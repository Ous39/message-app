package com.mycompany.messaging.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages") // Explicit table name
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 1000) // Content cannot be null and has a length limit
    private String content;

    @Column(nullable = false) // Ensure senderId is not null
    private Long senderId;

    @Column(nullable = false) // Ensure receiverId is not null
    private Long receiverId;

    @Column(nullable = false, updatable = false) // Set when the message is created
    private LocalDateTime timestamp;

    // Constructors
    public Message() {
        // Default constructor
    }

    public Message(String content, Long senderId, Long receiverId) {
        this.content = content;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.timestamp = LocalDateTime.now();
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
