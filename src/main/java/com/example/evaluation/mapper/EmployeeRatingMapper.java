package com.example.evaluation.mapper;

import com.example.evaluation.dtos.EmployeeRatingDto;
import com.example.evaluation.models.EmployeeRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeRatingMapper {
    EmployeeRatingDto toDto(EmployeeRating entity);
    EmployeeRating toEntity(EmployeeRatingDto dto);
}
