package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.DTO.LabTestUpdateDTO;
import com.raghav.medicallabtestmanagementsystem.Entity.LabTest;
import com.raghav.medicallabtestmanagementsystem.Service.LabTestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LabTestController {

    private final LabTestService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/admin/lab-tests")
    public ResponseEntity<?> CreateLabTest(@RequestBody LabTest labTest) {
        service.save(labTest);
        return ResponseEntity.ok("Created");
    }

    @GetMapping("/lab-tests")
    public ResponseEntity<List<LabTest>> getAlLabTests() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/lab-tests/{id}")
    public ResponseEntity<Optional<LabTest>> getTestById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getLabTestById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/admin/lab-tests/{labTestId}")
    public ResponseEntity<?> UpdateLabTest(@PathVariable Long labTestId, @RequestBody LabTestUpdateDTO dto){
        service.update(labTestId,dto);
        return ResponseEntity.ok("UPDATED");
    }
}

