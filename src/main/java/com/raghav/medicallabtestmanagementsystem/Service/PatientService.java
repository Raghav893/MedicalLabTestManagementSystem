package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.PatientProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import com.raghav.medicallabtestmanagementsystem.Repo.PatientRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final UserRepo userRepo;
    private final PatientRepository patientRepository;
    public void updateProfile(String username, PatientProfileUpdateDTO dto) {
        Users user = userRepo.findByUsername(username);

        if (user == null){
            throw new RuntimeException("User not found");
        }
        Patient patient = patientRepository.findByUser(user);
        if (patient == null){
            throw new RuntimeException("Patient profile Not Found !!");
        }

    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}
