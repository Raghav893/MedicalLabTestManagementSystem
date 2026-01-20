package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.DTO.DoctorProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.DTO.PatientProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.Doctor;
import com.raghav.medicallabtestmanagementsystem.Entity.Patient;
import com.raghav.medicallabtestmanagementsystem.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@PreAuthorize("hasAnyRole('DOCTOR','ADMIN')")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService service;
    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @RequestBody DoctorProfileUpdateDTO dto,
            Authentication authentication) {

        String username = authentication.getName();
        service.UpdateProfile(username, dto);
        return ResponseEntity.ok("Doctor profile updated");
    }
    @GetMapping("")
    public ResponseEntity<List<Doctor>> getallPatients(){
        return new ResponseEntity<>(service.getAllDoctors(), HttpStatus.OK);
    }
}
