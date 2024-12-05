package com.mycompany.messaging.model;

import javax.persistence.*;

@Entity
@Table(name = "subscribers") // Explicit table name
public class Subscriber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false) // Ensure listId is not null
    private Long listId;

    @Column(nullable = false, unique = true, length = 15) // Ensure phoneNumber is unique and constrained
    private String phoneNumber;

    // Constructors
    public Subscriber() {
        // Default constructor
    }

    public Subscriber(Long listId, String phoneNumber) {
        this.listId = listId;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getListId() {
        return listId;
    }

    public void setListId(Long listId) {
        this.listId = listId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
