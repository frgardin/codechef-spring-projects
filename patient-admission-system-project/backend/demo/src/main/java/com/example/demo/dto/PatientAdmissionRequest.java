package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAdmissionRequest {

    // TODO: Ensure the patient name is not null and not just whitespace. 
    // Hint: Include a custom message "Patient name cannot be blank"
    @NotBlank(message = "Patient name cannot be blank")
    private String name;

    // TODO: Validate that the age is at least 0 and at most 150. 
    // Use two separate annotations and provide custom error messages for each.
    // Hint: "Age cannot be negative" and "Invalid age provided"
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 150, message = "Invalid age provided")
    private int age;

    // TODO: Ensure Systolic BP is provided (not null). 
    // TODO: It must be a minimum of 50 and a maximum of 250.
    // Hint: Write approriate error messages: "Systolic BP is required", "Systolic BP too low, please double check input", "Systolic BP critically high, please double check input"
    @NotNull(message = "Systolic BP is required")
    @Min(value = 50, message = "Systolic BP too low, please double check input")
    @Max(value = 250, message = "Systolic BP critically high, please double check input")
    private Integer systolicBp;

    // TODO: Ensure Diastolic BP is provided (not null). 
    // TODO: It must be a minimum of 30 and a maximum of 150.
    // Hint: Write approriate error messages: "Diastolic BP is required", "Diastolic BP too low", "Diastolic BP too high"
    @NotNull(message = "Diastolic BP is required")
    @Min(value = 30, message = "Diastolic BP too low")
    @Max(value = 150, message = "Diastolic BP too high")
    private Integer diastolicBp;

    // TODO: Write the Getters and Setters for ALL fields
    // You have 2 options:
    // 1. Manually write all getters and setters
    // 2. Use Lombok's @Getter and @Setter annotations to auto-generate them
}


