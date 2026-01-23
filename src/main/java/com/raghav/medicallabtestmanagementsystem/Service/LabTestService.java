package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.Entity.LabTest;
import com.raghav.medicallabtestmanagementsystem.Repo.LabTestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabTestService {
    private final LabTestRepository repository;
    public void save(LabTest labTest) {
        labTest.setActive(true);
        repository.save(labTest);
    }

    public List<LabTest> getAll() {
        return repository.findAll();
    }
}
