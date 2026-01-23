package com.raghav.medicallabtestmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LabTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long labTestId;

    @Column(nullable = false,unique = true)
    private String testCode;

    @Column(nullable = false,unique = true)
    private String testName;

    @Column(nullable = false)
    private String description ;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private boolean   active;

    @OneToMany(mappedBy = "labTest")
    private List<TestParameter> parameters;


}
