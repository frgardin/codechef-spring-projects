package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.SecureZone;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.SecureZoneRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

// TODO: Mark this class as a Spring Service component so it can be injected into the Controller
@__________
public class AccessService {

    // TODO: Inject the EmployeeRepository and SecureZoneRepository using constructor injection
    ____________________
    ____________________

    public Employee createEmployee(Employee employee) {
        // TODO: Save the employee to the database and return the saved entity.
        // Note: Because of Cascading, saving the employee will also save their associated RFID card automatically!
        return ____________________
    }

    public SecureZone createZone(SecureZone zone) {
        // TODO: Save the secure zone to the database and return the saved entity.
        return ____________________
    }

    public Employee grantZoneAccess(Long employeeId, Long zoneId) {
        
        // 1. Fetch the Employee using Optional syntax
        // TODO: Use the repository to find the employee by their ID
        Optional<Employee> optionalEmployee = ____________________
        
        // TODO: Check if the employee is missing (if the Optional is empty)
        if (____________________) {
            // If the employee is not found, throw a RuntimeException a clear message.
            throw new RuntimeException("Employee not found");
        }
        
        // TODO: Extract the actual Employee object from the Optional wrapper
        Employee employee = ____________________;

        
        // 2. Fetch the Secure Zone using Optional syntax
        // TODO: Use the repository to find the zone by its ID
        Optional<SecureZone> optionalZone = ____________________
        
        // TODO: Check if the zone is missing
        if (____________________) {

            // If the zone is not found, throw a RuntimeException with a clear message.
            throw new RuntimeException("Zone not found");
        }
        
        // TODO: Extract the actual Zone object from the Optional wrapper
        SecureZone zone = ____________________


        // 3. Grant the access and save
        // TODO: Use the helper method you created in the Employee class to add the zone
        ____________________
        
        // TODO: Save the updated employee to the database and return the updated entity.
        // Note: This automatically updates the Many-to-Many Join Table (employee_zones).
        return ____________________;
    }

    public void revokeEmployee(Long employeeId) {
        // TODO: Delete the employee by their ID.
        // Note: Because of Cascading, deleting the employee will also delete their associated RFID card 
        // and safely remove all their entries from the "employee_zones" join table.
        ____________________
    }
}


