package com.raghav.medicallabtestmanagementsystem.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientProfileUpdateDTO {
    private String fullName;
    private LocalDate dob;
    private String phone;
}
