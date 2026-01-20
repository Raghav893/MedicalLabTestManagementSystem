package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.DTO.PatientProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyRole('PATIENT','ADMIN')")
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {
    private  final PatientService patientService;
    @PutMapping("/profile")
    public ResponseEntity<?> updateProfile(
            @RequestBody PatientProfileUpdateDTO dto,
            Authentication authentication) {

        String username = authentication.getName();
        patientService.updateProfile(username, dto);
        return ResponseEntity.ok("Patient profile updated");
    }
}
