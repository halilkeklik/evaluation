package com.example.evaluation.mapper;


import com.example.evaluation.dtos.BusinessRatingDto;
import com.example.evaluation.models.BusinessRating;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BusinessRatingMapper {
    BusinessRatingDto toDto(BusinessRating entity);
    BusinessRating toEntity(BusinessRatingDto dto);
}
