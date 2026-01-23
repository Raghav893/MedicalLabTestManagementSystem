package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.DTO.LabTestUpdateDTO;
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

    public void update(Long labTestId, LabTestUpdateDTO dto) {
        Optional<LabTest> labTestOptional = repository.findById(labTestId);
        LabTest labTest = labTestOptional.get();
        if (labTest == null){
            throw new RuntimeException("lab test not found");
        }
        labTest.setDescription(dto.getDescription());
        labTest.setPrice(dto.getPrice());
        labTest.setActive(dto.getActive());
    }

    public void deactivate(Long labTestId) {
        Optional<LabTest> labTestOptional = repository.findById(labTestId);
        LabTest labTest =  labTestOptional.get();
        if (labTest == null) {
            throw new RuntimeException("lab test not found");
        }
        labTest.setActive(false);
    }
}
