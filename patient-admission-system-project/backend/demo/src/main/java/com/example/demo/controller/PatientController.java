package com.example.demo.controller;

import com.example.demo.dto.PatientAdmissionRequest;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientStatus;
import com.example.demo.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// TODO: Mark this class as a REST Controller
@RestController
// TODO: Map all requests in this controller to start with "/api"
@RequestMapping("/api")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    // TODO: Map this method to handle POST requests at "/admit"
    @PostMapping("/admit")
    // TODO: Ensure the incoming request body is Validated and mapped to the PatientAdmissionRequest object
    public ResponseEntity<Patient> admitPatient(@Valid @RequestBody PatientAdmissionRequest request) {
        // TODO: Call the service method to admit the patient and store the returned Patient object
        Patient admittedPatient = service.admitPatient(request);
        
        // TODO: Return the admitted patient along with a 201 CREATED HTTP status
        return new ResponseEntity<>(admittedPatient, HttpStatus.CREATED);
    }

    // TODO: Map this method to handle GET requests at "/critical"
    @GetMapping("/critical")
    public ResponseEntity<List<Patient>> getCriticalPatients() {
        // TODO: Return the list of critical patients with a 200 OK status
        return ResponseEntity.ok(service.getCriticalPatients());
    }

    // TODO: Map this method to handle GET requests at "/{id}"
    @GetMapping("/{id}")
    // TODO: Extract the "id" variable from the URL path
    public ResponseEntity<Patient> getPatient(@PathVariable Long id) {

        // TODO: Call the service method to fetch the patient record by ID and return it with a 200 OK status
        return ResponseEntity.ok(service.getPatientRecord(id));
    }

    // Endpoint to get patients with BP exceeding specified limits
    // TODO: Map this method to handle GET requests at "/alerts/high-bp"
    @GetMapping("/alerts/high-bp")
    // TODO: Extract "sys" and "dia" from the URL query parameters (e.g., ?sys=150&dia=100)
    public ResponseEntity<List<Patient>> getHighBpPatients(@RequestParam int sys, @RequestParam int dia) {

        // TODO: Call the service method to fetch patients with high vitals and return the list with a 200 OK status
        return ResponseEntity.ok(service.getPatientsWithHighVitals(sys, dia));
    }

    // Endpoint to update patient status
    // TODO: Map this method to handle PUT requests at "/{id}/status"
    @PutMapping("/{id}/status")
    // TODO: Extract "id" from the path and "status" from the query parameters
    public ResponseEntity<Patient> updateStatus(@PathVariable Long id, @RequestParam PatientStatus status) {

        // TODO: Call the service method to update the patient's status and return the updated patient with a 200 OK status
        Patient updatedPatient = service.updatePatientStatus(id, status);

        return ResponseEntity.ok(updatedPatient);
    }

    // Endpoint to discharge a patient
    // TODO: Map this method to handle DELETE requests at "/{id}/discharge"
    @DeleteMapping("/{id}/discharge")
    public ResponseEntity<Void> dischargePatient(@PathVariable Long id) {

        // TODO: Call the service method to discharge (delete) the patient record
        service.dischargePatient(id);
        
        // TODO: Return a 204 NO CONTENT HTTP status since the record was deleted and there is no body to return
        return ResponseEntity.noContent().build();
    }
}


