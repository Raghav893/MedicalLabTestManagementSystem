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
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long Id;

    @OneToOne
    @JoinColumn(name = "userId")
    private Users user;

    private String Fullname;

    private LocalDate Dob;

    @Enumerated(EnumType.STRING)
    private String gender;

    private int phone;


}
