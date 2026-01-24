package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByUser(Users user);

    Patient findPatientByFullnameIsWithinIgnoreCase(String username);

}
