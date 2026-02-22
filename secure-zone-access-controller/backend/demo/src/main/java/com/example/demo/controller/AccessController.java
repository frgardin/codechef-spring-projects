package com.example.demo.controller;

import com.example.demo.model.Employee;
import com.example.demo.model.SecureZone;
import com.example.demo.service.AccessService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// TODO: Mark this class as a Spring REST Controller
@__________
// TODO: Set the base routing path for this entire controller to "/api"
@__________
public class AccessController {

    // TODO: Inject the AccessService using constructor injection
    __________________________
    __________________________

    // 1. Create a new Employee (with their One-to-One RFID card attached in the JSON request)
    // TODO: Map this method to handle POST requests at the "/employees" endpoint
    @____________________
    // TODO: Extract the Employee object from the incoming JSON request body
    public ResponseEntity<Employee> addEmployee(@__________ Employee employee) {

        // TODO: Call the service method to save the employee and return the saved entity in the OK response.
        return ResponseEntity.______(__________________);
    }

    // 2. Create a new Secure Zone
    // TODO: Map this method to handle POST requests at the "/zones" endpoint
    @____________________
    // TODO: Extract the SecureZone object from the incoming JSON request body
    public ResponseEntity<SecureZone> addZone(@__________ SecureZone zone) {

        // TODO: Call the service method to save the zone and return the saved entity in the OK response.
        return ResponseEntity.______(__________________);
    }

    // 3. Give an Employee access to a Secure Zone
    // TODO: Map this method to handle POST requests at the "/employees/{employeeId}/zones/{zoneId}" endpoint
    @________________
    // TODO: Extract both 'employeeId' and 'zoneId' from the URL path variables
    public ResponseEntity<Employee> grantAccess(@__________ Long employeeId, @__________ Long zoneId) {

        // TODO: Call the service method to grant the access and return the updated Employee entity in the OK response.
        return ResponseEntity.______(__________________);
    }

    // 4. Deleting the employee should remove their RFID card from the DB too
    // TODO: Map this method to handle DELETE requests at the "/employees/{employeeId}" endpoint
    @________________
    // TODO: Extract the 'employeeId' from the URL path variable
    public ResponseEntity<String> removeEmployee(@__________ Long employeeId) {

        // TODO: Call the service method to delete the employee by their ID.
        _____________________

        return ResponseEntity.ok("Employee, their RFID Card, and zone mappings have been securely removed.");
    }
}


