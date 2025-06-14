package com.example.evaluation.mapper;

import com.example.evaluation.dtos.BusinessDto;
import com.example.evaluation.models.Business;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BusinessMapper {

    BusinessMapper INSTANCE = Mappers.getMapper(BusinessMapper.class);

    @Mapping(source = "owner.id", target = "ownerId")
    BusinessDto toDto(Business business);

    @Mapping(source = "ownerId", target = "owner.id")
    Business toEntity(BusinessDto dto);
}
