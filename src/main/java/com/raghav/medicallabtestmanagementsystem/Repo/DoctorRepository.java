package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
