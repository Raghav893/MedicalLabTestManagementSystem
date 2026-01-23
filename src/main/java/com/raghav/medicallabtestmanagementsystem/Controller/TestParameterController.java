package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.Entity.TestParameter;
import com.raghav.medicallabtestmanagementsystem.Service.TestParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestParameterController {
    private final TestParamService service;

    @PostMapping("/admin/lab-tests/{labTestId}/parameters")
    public ResponseEntity<TestParameter> AddTestparameter(@RequestBody TestParameter testParameter, @PathVariable Long labTestId) {
        return new ResponseEntity<>(service.addParam(testParameter,labTestId), HttpStatus.CREATED);
    }

}
