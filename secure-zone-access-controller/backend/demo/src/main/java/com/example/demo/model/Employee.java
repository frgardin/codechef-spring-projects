package com.example.demo.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

// TODO: Mark this class as a JPA Entity
@__________
public class Employee {

    // TODO: Define the Primary Key
    @__________
    // TODO: Set the generation strategy to IDENTITY (Auto-Increment)
    @__________
    private Long id;
    
    private String name;
    private String department;

    // RELATIONSHIP MAPPING SECTION 1: ONE-TO-ONE

    // TODO: Define the relationship: One Employee has exactly One RfidCard
    // Challenge 1: Configure 'cascade' to ALL operations (saving/deleting employee affects the card).
    // Challenge 2: Enable 'orphanRemoval' so if a card is unlinked, it gets deleted from the DB.
    @__________(_______________, _______________)
    // Challenge 3: Create the Foreign Key column.
    //              - Name the column "rfid_card_id"
    //              - Point it to the "id" column of the RfidCard table.
    @__________(name = "__________", referencedColumnName = "__________")
    private RfidCard rfidCard;

    // RELATIONSHIP MAPPING SECTION 2: MANY-TO-MANY & JOIN TABLE

    // TODO: Define the relationship: Many Employees can access Many SecureZones
    @__________
    // Challenge 4: Create a junction table to manage this Many-to-Many relationship in the DB.
    //              - Name the junction table "employee_zones"
    //              - Set the foreign key for this entity (Employee) to "employee_id"
    //              - Set the foreign key for the other entity (SecureZone) to "zone_id"
    @__________(
        name = "__________",
        joinColumns = @__________(name = "__________"),
        inverseJoinColumns = @__________(name = "__________")
    )

    // We use a Set instead of a List to avoid duplicate zones for an employee.
    // Challenge 5: Initialize the Set to prevent NullPointerExceptions when adding zones.
    private Set<SecureZone> allowedZones = ________________;

    // TODO: Write teh helper method to assign zones to an employee (this will be used in the service layer to manage the relationship)
    public void addZone(SecureZone zone) {
        _______________________
    }

    // CONSTRUCTORS:
    // No-args constructor is required by JPA
    public Employee() {
        
    }

    // TODO: Write the Getters and Setters for all fields (including relationships)
    // You have 2 options: 
    // 1. Manually write them
    // 2. Use Lombok annotations at the top of the class to generate them automatically

    _______________________
    _______________________
    _______________________
    _______________________
    
}


