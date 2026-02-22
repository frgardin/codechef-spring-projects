package com.example.demo.service;

import com.example.demo.dto.PatientAdmissionRequest;
import com.example.demo.model.Patient;
import com.example.demo.model.PatientStatus;
import com.example.demo.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;
import java.util.List;

// TODO: Mark this class as a Spring Service component
@Service
public class PatientService {

    // TODO: Inject the PatientRepository using constructor injection
    private final PatientRepository repository;
    
    public PatientService(PatientRepository repository) {
        this.repository = repository;
    }

    public Patient admitPatient(PatientAdmissionRequest request) {
        Patient patient = new Patient();
        
        // TODO: Map the data from the 'request' DTO to the 'patient' Entity
        // Hint: Use the getters from the request and setters on the patient
        patient.setName(request.getName());
        patient.setAge(request.getAge());
        patient.setSystolicBp(request.getSystolicBp());
        patient.setDiastolicBp(request.getDiastolicBp());

        // TODO: Implement the Auto-trigger critical flag logic
        // 1. If Systolic BP >= 180 OR Diastolic BP >= 120, set status to CRITICAL
        // 2. Else If Systolic BP >= 140 OR Diastolic BP >= 90, set status to OBSERVATION
        // 3. Otherwise, set status to NORMAL
        if (patient.getSystolicBp() >= 180 || patient.getDiastolicBp() >= 120) {
            patient.setStatus(PatientStatus.CRITICAL);
        } else if (patient.getSystolicBp() >= 140 || patient.getDiastolicBp() >= 90) {
            patient.setStatus(PatientStatus.OBSERVATION);
        } else {
            patient.setStatus(PatientStatus.NORMAL);
        }

        // TODO: Save the patient entity to the database and return the saved object
        return repository.save(patient);
    }

    public List<Patient> getCriticalPatients() {
        // TODO: Fetch all patients who have a CRITICAL status using the custom derived query
        return repository.findByStatus(PatientStatus.CRITICAL);
    }

    public Patient getPatientRecord(Long id) {
        // Step 1: Try to find the patient in the database. 
        // TODO: Call the repository method that finds an entity by its ID
        Optional<Patient> optionalPatient = repository.findById(id);

        // Step 2: Explicitly check if the patient record was actually found
        // TODO: Use the appropriate Optional method to check if a value is present
        if (optionalPatient.isPresent()) {
            
            // Step 3: If it exists, extract the actual Patient object and return it
            // TODO: Extract the value from the Optional
            return optionalPatient.get();
            
        } else {
            // If it does not exist, throw a 404 NOT_FOUND error
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient with ID " + id + " not found.");
        }
    }

    // Fetch patients based on custom JPQL query for high vitals
    public List<Patient> getPatientsWithHighVitals(int sysLimit, int diaLimit) {
        // TODO: Call the custom JPQL method you defined in the repository
        return repository.findPatientsWithHighBp(sysLimit, diaLimit);
    }

    // Manually update a patient's status
    public Patient updatePatientStatus(Long id, PatientStatus newStatus) {
        // TODO: Reuse your existing method to fetch the patient record by ID
        Patient patient = getPatientRecord(id);
        
        // TODO: Update the status 
        patient.setStatus(newStatus);
        
        // TODO: Save the updated record to the database
        return repository.save(patient);
    }

    // Discharge a patient (delete record)
    public void dischargePatient(Long id) {
        // TODO: Fetch the patient record first
        Patient patient = getPatientRecord(id);
        
        // TODO: Use the repository to delete the fetched patient record
        repository.delete(patient);
    }
}


