package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.LoginDTO;
import com.raghav.medicallabtestmanagementsystem.DTO.RegisterDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.*;
import com.raghav.medicallabtestmanagementsystem.Repo.DoctorRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.PatientRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PatientRepository patientRepository;
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final DoctorRepository doctorRepository;
    public Users register(RegisterDTO dto){
        Roles role;
        try {
            role = Roles.valueOf(dto.getRole().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }

        Users users = new Users();
        users.setGender(Gender.valueOf(dto.getGender()));
        users.setUsername(dto.getUsername());
        users.setPassword(dto.getPassword());
        users.setRole(Roles.valueOf(dto.getRole()));
        users.setEnabled(true);
        users.setCreatedAt(LocalDateTime.now());
        users.setAuthProvider("JWT");
         userRepo.save(users);

        switch (role){
            case PATIENT:
                Patient patient = new Patient();
                patient.setUser(users);
                patient.setGender(Gender.valueOf(String.valueOf(users.getGender())));
                patientRepository.save(patient);


            case DOCTOR:
                Doctor doctor = new Doctor();
                doctor.setUsers(users);
                doctor.setGender(String.valueOf(users.getGender()));
                doctorRepository.save(doctor);

        }
        return  users;



    }
    public String verify(LoginDTO dto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        dto.getUsername(),
                        dto.getPassword()
                ));
        Users user  = userRepo.findByUsername(dto.getUsername());
        return jwtService.genrateToken(user.getUsername(),user.getRole().name());



    }

}
