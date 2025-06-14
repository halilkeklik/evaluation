package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.BusinessDto;
import com.example.evaluation.mapper.BusinessMapper;
import com.example.evaluation.models.Business;
import com.example.evaluation.repository.BusinessRepository;
import com.example.evaluation.service.BusinessService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository repository;
    private final BusinessMapper mapper;

    public BusinessServiceImpl(BusinessRepository repository, BusinessMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BusinessDto createBusiness(BusinessDto dto) {
        Business entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<BusinessDto> getAllBusinesses() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BusinessDto getBusinessById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public BusinessDto updateBusiness(Long id, BusinessDto dto) {
        if (!repository.existsById(id)) return null;
        Business entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteBusiness(Long id) {
        repository.deleteById(id);
    }
}