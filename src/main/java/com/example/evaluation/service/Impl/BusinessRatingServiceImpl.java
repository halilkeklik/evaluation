package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.BusinessRatingDto;
import com.example.evaluation.mapper.BusinessRatingMapper;
import com.example.evaluation.models.BusinessRating;
import com.example.evaluation.repository.BusinessRatingRepository;
import com.example.evaluation.service.BusinessRatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusinessRatingServiceImpl implements BusinessRatingService {

    private final BusinessRatingRepository repository;
    private final BusinessRatingMapper mapper;

    public BusinessRatingServiceImpl(BusinessRatingRepository repository, BusinessRatingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public BusinessRatingDto createBusinessRating(BusinessRatingDto dto) {
        BusinessRating entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<BusinessRatingDto> getAllBusinessRatings() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public BusinessRatingDto getBusinessRatingById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public BusinessRatingDto updateBusinessRating(Long id, BusinessRatingDto dto) {
        if (!repository.existsById(id)) return null;
        BusinessRating entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteBusinessRating(Long id) {
        repository.deleteById(id);
    }
}