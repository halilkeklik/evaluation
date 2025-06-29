package com.example.evaluation.service;

import com.example.evaluation.dtos.BusinessDto;

import java.util.List;

public interface BusinessService {
    BusinessDto createBusiness(BusinessDto dto);

    List<BusinessDto> getAllBusinesses();

    BusinessDto getBusinessById(Long id);
    BusinessDto updateBusiness(Long id, BusinessDto dto);
    void deleteBusiness(Long id);
    BusinessDto getByName(String name);
}
