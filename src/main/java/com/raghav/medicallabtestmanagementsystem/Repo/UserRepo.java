package com.raghav.medicallabtestmanagementsystem.Repo;

import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.font.LayoutPath;

public interface UserRepo extends JpaRepository<Users, Long> {
    Users findByUsername(String username);
}
