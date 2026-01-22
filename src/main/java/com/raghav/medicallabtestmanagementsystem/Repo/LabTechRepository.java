package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.LabTechnician;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LabTechRepository extends JpaRepository<LabTechnician, Long> {
    LabTechnician findByUsers(Users users);
}
