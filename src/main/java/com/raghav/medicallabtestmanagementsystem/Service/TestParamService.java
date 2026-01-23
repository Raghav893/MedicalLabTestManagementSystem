package com.raghav.medicallabtestmanagementsystem.Service;

import com.raghav.medicallabtestmanagementsystem.Entity.LabTest;
import com.raghav.medicallabtestmanagementsystem.Entity.TestParameter;
import com.raghav.medicallabtestmanagementsystem.Repo.LabTestRepository;
import com.raghav.medicallabtestmanagementsystem.Repo.TestParamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestParamService {


        private final TestParamRepository testParameterRepository;
        private final LabTestRepository labTestRepository;



        public TestParameter addParam(TestParameter testParameter, Long labTestId) {

            LabTest labTest = labTestRepository.findById(labTestId)
                    .orElseThrow(() -> new RuntimeException("LabTest not found"));

            testParameter.setLabTest(labTest);

            return testParameterRepository.save(testParameter);
        }
    }

