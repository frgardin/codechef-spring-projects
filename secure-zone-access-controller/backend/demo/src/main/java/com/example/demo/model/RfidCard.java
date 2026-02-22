package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

// TODO: Mark this class as a JPA Entity
@__________
public class RfidCard {
    
    // TODO: Define the Primary Key
    @__________
    // TODO: Set the generation strategy to IDENTITY (Auto-Increment)
    @__________
    private Long id;
    
    // TODO: Configure the column properties
    // Challenge 1: The card number must be unique across the database.
    // Challenge 2: The card number cannot be null.
    @__________
    private String cardNumber;
    
    private LocalDate issueDate;

    // CONSTRUCTORS:
    // No-args constructor is required by JPA
    public RfidCard() {

    }

    // TODO: Create a constructor that initializes all fields except 'id' (since it's auto-generated)
    _________________
    _________________

    // TODO: Write the Getters and Setters for all fields
    // You have 2 options: 
    // 1. Manually write them
    // 2. Add Lombok annotations at the top of the class to generate them automatically

    __________________________________________________
    __________________________________________________
    __________________________________________________
    __________________________________________________
    
}


