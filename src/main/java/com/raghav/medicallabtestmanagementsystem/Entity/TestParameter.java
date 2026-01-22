package com.raghav.medicallabtestmanagementsystem.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestParameter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long TestParamId;

    @OneToOne
    @JoinColumn(name = "labTestId")
    private LabTest labTest;

    @Column(nullable = false)
    private String parameterName;

    @Column(nullable = false)
    private String unit;

    @Column(nullable = false)
    BigDecimal minRange;

    @Column(nullable = false)
    BigDecimal maxRange;
}
