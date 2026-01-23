package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.Entity.LabTest;
import com.raghav.medicallabtestmanagementsystem.Repo.LabTestRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LabTestService {
    private final LabTestRepository repository;
    public void save(@NotNull LabTest labTest) {
        labTest.setActive(true);
        repository.save(labTest);
    }

    public List<LabTest> getAll() {
        return repository.findAll();
    }
    public Optional<LabTest> getLabTestById(Long id){
        return repository.findById(id);
    }
}
