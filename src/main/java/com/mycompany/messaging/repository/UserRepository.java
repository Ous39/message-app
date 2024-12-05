package com.mycompany.messaging.repository;

import com.mycompany.messaging.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find user by username
    Optional<User> findByUsername(String username);

    // Find user by email (useful for authentication or registration)
    Optional<User> findByEmail(String email);

    // Find user by phone number (if needed for communication or validation)
    Optional<User> findByPhone(String phone);

    // Custom query to check if a username already exists
    boolean existsByUsername(String username);

    // Custom query to check if an email already exists
    boolean existsByEmail(String email);

    // Custom query to check if a phone number already exists
    boolean existsByPhone(String phone);
}
