package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.EmployeeRatingDto;
import com.example.evaluation.mapper.EmployeeRatingMapper;
import com.example.evaluation.models.EmployeeRating;
import com.example.evaluation.repository.EmployeeRatingRepository;
import com.example.evaluation.service.EmployeeRatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeRatingServiceImpl implements EmployeeRatingService {

    private final EmployeeRatingRepository repository;
    private final EmployeeRatingMapper mapper;

    public EmployeeRatingServiceImpl(EmployeeRatingRepository repository, EmployeeRatingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public EmployeeRatingDto createEmployeeRating(EmployeeRatingDto dto) {
        EmployeeRating entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<EmployeeRatingDto> getAllEmployeeRatings() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeRatingDto getEmployeeRatingById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public EmployeeRatingDto updateEmployeeRating(Long id, EmployeeRatingDto dto) {
        if (!repository.existsById(id)) return null;
        EmployeeRating entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteEmployeeRating(Long id) {
        repository.deleteById(id);
    }
}