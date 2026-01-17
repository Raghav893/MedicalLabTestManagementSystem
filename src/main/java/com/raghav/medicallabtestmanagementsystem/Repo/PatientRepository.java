package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
