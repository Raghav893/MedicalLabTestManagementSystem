package com.raghav.medicallabtestmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @OneToOne
    @JoinColumn(name = "userId")
    private Users users;

    private String FullName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String specialization;

    private String phone;

    private LocalDate Dob;

    private Long registrationNumber;

}
