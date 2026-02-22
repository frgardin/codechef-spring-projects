package com.example.demo.entity;

import jakarta.persistence.*;

// TODO: Mark this class as a JPA Entity
@Entity
// TODO: Map this entity to a table named "members" in the database
@Table(name = "members")
public class Member {

    // TODO: Define the Primary Key for this entity
    @Id
    // TODO: Set the generation strategy to IDENTITY (Auto-Increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    // Soft Delete Concept: true if deleted, false otherwise
    private boolean isDeleted = false;

    // CONSTRUCTORS:
    // No-args constructor is required by JPA
    public Member() {

    }

    // TODO: Create a constructor that takes 'name' and 'email' as parameters
    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // TODO: Write the Getters and Setters for ALL fields (id, name, email, isDeleted)
    // Hint: For the boolean field 'isDeleted', the getter is typically named isDeleted() 
    // and the setter is setDeleted()
    public Long getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}