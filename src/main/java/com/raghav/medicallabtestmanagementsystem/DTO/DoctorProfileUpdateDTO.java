package com.raghav.medicallabtestmanagementsystem.DTO;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DoctorProfileUpdateDTO{
    private String FullName;
    private String specialization;
    private String phone;
    private LocalDate Dob;
    private Long registrationNumber;

}
