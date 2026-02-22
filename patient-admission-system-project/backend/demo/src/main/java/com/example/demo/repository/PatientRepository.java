package com.example.demo.repository;

import com.example.demo.model.Patient;
import com.example.demo.model.PatientStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

// TODO: Mark this interface as a Spring Data Repository component
@Repository
// TODO: Extend the correct Spring Data interface for JPA. 
// Hint: You need to specify the Entity class and the data type of its Primary Key.
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // TODO: Write a Spring Data JPA derived query method to find all patients by their status.
    // Hint: Spring will automatically generate the SQL if you name the method correctly using 'findBy...' conventions.
    List<Patient> findByStatus(PatientStatus status);
    
    // TODO: Write a custom JPQL query to find patients whose systolic BP is strictly greater than the first parameter (?1) 
    // OR whose diastolic BP is strictly greater than the second parameter (?2).
    // Hint: Remember that JPQL queries against the Java Entity (Patient p) and its properties, not the database table!
    @Query("SELECT p FROM Patient p WHERE p.systolicBp > ?1 OR p.diastolicBp > ?2")
    List<Patient> findPatientsWithHighBp(int systolicLimit, int diastolicLimit);
}