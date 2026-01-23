package com.raghav.medicallabtestmanagementsystem.DTO;

import lombok.Data;

@Data
public class LabTestUpdateDTO {
    String description;
    int price;
    boolean active;
}
