package com.mycompany.messaging.repository;

import com.mycompany.messaging.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Custom query to find messages by senderId
    List<Message> findBySenderId(Long senderId);

    // Custom query to find messages by receiverId
    List<Message> findByReceiverId(Long receiverId);

    // Custom query to find messages by sender and receiver
    List<Message> findBySenderIdAndReceiverId(Long senderId, Long receiverId);

    // Custom query to search messages by content (using partial match)
    List<Message> findByContentContainingIgnoreCase(String content);
}
