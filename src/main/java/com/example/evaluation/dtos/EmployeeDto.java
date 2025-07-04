package com.example.evaluation.dtos;

import lombok.Data;

@Data
public class EmployeeDto {
    private Long id;
    private String fullName;
    private Double avgRating;
    private Long businessId;
}