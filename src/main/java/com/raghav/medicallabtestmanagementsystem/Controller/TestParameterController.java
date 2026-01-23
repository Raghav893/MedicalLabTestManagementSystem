package com.raghav.medicallabtestmanagementsystem.Controller;

import com.raghav.medicallabtestmanagementsystem.Entity.TestParameter;
import com.raghav.medicallabtestmanagementsystem.Service.TestParamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestParameterController {
    private final TestParamService service;

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/admin/lab-tests/{labTestId}/parameters")
    public ResponseEntity<TestParameter> AddTestparameter(@RequestBody TestParameter testParameter, @PathVariable Long labTestId) {
        return new ResponseEntity<>(service.addParam(testParameter,labTestId), HttpStatus.CREATED);
    }

    @GetMapping("/lab-tests/{labTestId}/parameters")
    public ResponseEntity<List<TestParameter>> getParamsOfTest(@PathVariable Long labTestId) {
        return new ResponseEntity<>(service.getTestParamByLabTestId(labTestId),HttpStatus.OK);
    }

}
