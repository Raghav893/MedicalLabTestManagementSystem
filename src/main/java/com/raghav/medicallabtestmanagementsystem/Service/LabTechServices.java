package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.LabTechProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.LabTechnician;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
import com.raghav.medicallabtestmanagementsystem.Repo.LabTechRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabTechServices {

    private final LabTechRepository repo;
    private final UserRepo userRepo;
    public void updateProfile(String username,LabTechProfileUpdateDTO dto){

        Users users = userRepo.findByUsername(username);
        if (users == null) {
            throw new RuntimeException("User not found ");
        }
        LabTechnician technician = repo.findByUsers(users);
        if (technician == null) {
            throw new RuntimeException(" Lab Technician not found");
        }
        if (dto.getLabBranch() != null) technician.setLabBranch(dto.getLabBranch());
        if (dto.getEmployeeCode() !=null) technician.setEmployeeCode(dto.getEmployeeCode());

    }
    public List<LabTechnician> getAllLabtech(){
        return repo.findAll();
    }

}
