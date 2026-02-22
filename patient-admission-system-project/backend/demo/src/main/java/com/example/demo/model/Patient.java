package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


// TODO: Mark this class as a JPA Entity
@Entity
// TODO: Map this entity to a table named "patients" in the database
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    // TODO: Define the Primary Key for this entity
    @Id
    // TODO: Set the generation strategy to IDENTITY (Auto-Increment)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    
    private int age;

    // Vital Signs (Systolic and Diastolic Blood Pressure)
    private int systolicBp;
    
    private int diastolicBp;

    // TODO: Ensure this enum is stored as a STRING in the database (not as an integer)
    @Enumerated(EnumType.STRING)
    private PatientStatus status;

    // CONSTRUCTORS:
    // No-args constructor is required by JPA
    public Patient() {

    }

    // TODO: Create a constructor that takes all fields EXCEPT 'id' and 'status' as parameters
    public Patient(String name, int age, int systolicBp, int diastolicBp) {
        this.name = name;
        this.age = age;
        this.systolicBp = systolicBp;
        this.diastolicBp = diastolicBp;
    }

    // TODO: Write the Getters and Setters for ALL fields
    // You have 2 options:
    // 1. Manually write all getters and setters
    // 2. Use Lombok's @Getter and @Setter annotations to auto-generate them
}