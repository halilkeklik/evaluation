package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.RatingTypeMappingDto;
import com.example.evaluation.mapper.RatingTypeMappingMapper;
import com.example.evaluation.models.RatingTypeMapping;
import com.example.evaluation.repository.RatingTypeMappingRepository;
import com.example.evaluation.service.RatingTypeMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingTypeMappingServiceImpl implements RatingTypeMappingService {

    private final RatingTypeMappingRepository repository;
    private final RatingTypeMappingMapper mapper;

    public RatingTypeMappingServiceImpl(RatingTypeMappingRepository repository, RatingTypeMappingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RatingTypeMappingDto createRatingTypeMapping(RatingTypeMappingDto dto) {
        RatingTypeMapping entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<RatingTypeMappingDto> getAllRatingTypeMappings() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RatingTypeMappingDto getRatingTypeMappingById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public RatingTypeMappingDto updateRatingTypeMapping(Long id, RatingTypeMappingDto dto) {
        if (!repository.existsById(id)) return null;
        RatingTypeMapping entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteRatingTypeMapping(Long id) {
        repository.deleteById(id);
    }
}