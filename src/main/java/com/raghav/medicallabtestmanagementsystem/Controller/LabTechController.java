package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.DTO.LabTechProfileUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.LabTechnician;
import com.raghav.medicallabtestmanagementsystem.Service.LabTechServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tech")
@RequiredArgsConstructor
@PreAuthorize("hasAnyRole('ADMIN','LAB_TECH')")
public class LabTechController {
    private final LabTechServices services;

    @PutMapping("/profile")
    public ResponseEntity<?> UpdateTechProfile(@RequestBody LabTechProfileUpdateDTO labTechProfileUpdateDTO, Authentication authentication)
    {
        String username = authentication.getName();
        services.updateProfile(username,labTechProfileUpdateDTO);
        return ResponseEntity.ok("Lab Tech Profile updated");

    }

    @GetMapping("")
    public ResponseEntity<List<LabTechnician>> getallLabTech() {
        return new ResponseEntity<>(services.getAllLabtech(), HttpStatus.OK);
    }
}
