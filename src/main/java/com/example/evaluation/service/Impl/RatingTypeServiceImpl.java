package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.RatingTypeDto;
import com.example.evaluation.mapper.RatingTypeMapper;
import com.example.evaluation.models.RatingType;
import com.example.evaluation.repository.RatingTypeRepository;
import com.example.evaluation.service.RatingTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RatingTypeServiceImpl implements RatingTypeService {

    private final RatingTypeRepository repository;
    private final RatingTypeMapper mapper;

    public RatingTypeServiceImpl(RatingTypeRepository repository, RatingTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public RatingTypeDto createRatingType(RatingTypeDto dto) {
        RatingType entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<RatingTypeDto> getAllRatingTypes() {
        return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RatingTypeDto getRatingTypeById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElse(null);
    }

    @Override
    public RatingTypeDto updateRatingType(Long id, RatingTypeDto dto) {
        if (!repository.existsById(id)) return null;
        RatingType entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteRatingType(Long id) {
        repository.deleteById(id);
    }
}