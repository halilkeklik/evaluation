package com.example.evaluation.dtos;

import com.example.evaluation.models.BusinessType;
import lombok.Data;

@Data
public class BusinessDto {
    private Long id;
    private String name;
    private BusinessType type;
    private Double avgRating;
    private Long ownerId;
}

