package com.raghav.medicallabtestmanagementsystem.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class RolecheckService {
    public boolean PatientCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean ispatient = authentication.getAuthorities()
                .stream()
                .anyMatch(a->a.getAuthority().equals("ROLE_PATIENT"));
        return ispatient;
    }
    public boolean AdminCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isAdmin = authentication.getAuthorities()
                .stream()
                .anyMatch(a->a.equals("ROLE_ADMIN"));
        return isAdmin;
    }
    public boolean DoctorCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isDoctor = authentication.getAuthorities()
                .stream()
                .anyMatch(a->a.equals("ROLE_DOCTOR"));
        return isDoctor;

    }
    public boolean TechCheck(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        boolean isTech = authentication.getAuthorities()
                .stream()
                .anyMatch(a->a.equals("ROLE_LAB_TECH"));
        return isTech;
    }
}
