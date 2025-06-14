package com.example.evaluation.mapper;

import com.example.evaluation.dtos.EmployeeDto;
import com.example.evaluation.models.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "business.id", target = "businessId")
    EmployeeDto toDto(Employee employee);

    @Mapping(source = "businessId", target = "business.id")
    Employee toEntity(EmployeeDto dto);
}
