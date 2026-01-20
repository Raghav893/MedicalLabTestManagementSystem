package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.DoctorProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.Doctor;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import com.raghav.medicallabtestmanagementsystem.Repo.DoctorRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final UserRepo userRepo;
    public void UpdateProfile(String Username, DoctorProfileUpdateDTO dto){
        Users user = userRepo.findByUsername(Username);
        if (user == null){
            throw new RuntimeException("User not found");
        }
        Doctor doctor = doctorRepository.findByUsers(user);
        if (doctor == null){
            throw new RuntimeException("Patient profile Not Found !!");
        }
        if (dto.getFullName() != null) doctor.setFullName(dto.getFullName());
        if (dto.getDob() != null) doctor.setDob(dto.getDob());
        if (dto.getPhone() != null) doctor.setPhone(dto.getPhone());
        if (dto.getSpecialization() != null) doctor.setSpecialization(dto.getSpecialization());
        doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {

        return doctorRepository.findAll();
    }
}
