package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.LoginDTO;
import com.raghav.medicallabtestmanagementsystem.DTO.RegisterDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.Gender;
import com.raghav.medicallabtestmanagementsystem.Entity.Roles;
import com.raghav.medicallabtestmanagementsystem.Entity.Users;
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
    private final UserRepo userRepo;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    public Users register(RegisterDTO dto){
        Users users = new Users();
        users.setGender(Gender.valueOf(dto.getGender()));
        users.setUsername(dto.getUsername());
        users.setPassword(dto.getPassword());
        users.setRole(Roles.valueOf(dto.getRole()));
        users.setEnabled(true);
        users.setCreatedAt(LocalDateTime.now());
        users.setAuthProvider("JWT");
        return userRepo.save(users);
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
