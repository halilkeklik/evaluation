package com.example.evaluation.dtos;

import lombok.Data;

@Data
public class ProductDto {
    private Long id;
    private String name;
    private Long businessId;
    private Double avgRating;
}
