package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.BusinessDto;
import com.example.evaluation.mapper.BusinessMapper;
import com.example.evaluation.models.Business;
import com.example.evaluation.repository.BusinessRepository;
import com.example.evaluation.repository.RatingTypeMappingRepository;
import com.example.evaluation.service.BusinessService;
import com.example.evaluation.service.RatingTypeMappingService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessServiceImpl implements BusinessService {

    private final BusinessRepository repository;
    private final BusinessMapper mapper;
    private final RatingTypeMappingService ratingTypeMappingService;

    public BusinessServiceImpl(BusinessRepository repository, BusinessMapper mapper, RatingTypeMappingRepository ratingTypeMappingRepository, RatingTypeMappingService ratingTypeMappingService) {
        this.repository = repository;
        this.mapper = mapper;
        this.ratingTypeMappingService = ratingTypeMappingService;
    }

    @Override
    public BusinessDto createBusiness(BusinessDto dto) {
        Business entity = mapper.toEntity(dto);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public List<BusinessDto> getAllBusinesses() {
        return repository.findAll().stream().map(business -> {
            BusinessDto dto = mapper.toDto(business);
            Double avgRating = ratingTypeMappingService.findAverageRatingByBusinessId(business.getId());
            dto.setAvgRating(avgRating);
            return dto;
        }).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public BusinessDto getBusinessById(Long id) {

        Optional<Business> business = Optional.ofNullable(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("isletme bulunamadi")));
        BusinessDto dto = new BusinessDto();
        dto.setId(business.get().getId());
        dto.setName(business.get().getName());
        dto.setId(business.get().getId());
        dto.setType(business.get().getType());
        dto.setOwnerId(business.get().getOwner().getId());
        dto.setAvgRating(ratingTypeMappingService.findAverageRatingByBusinessId(id));
        return dto;
    }

    @Override
    public BusinessDto updateBusiness(Long id, BusinessDto dto) {
        if (!repository.existsById(id)) return null;
        Business entity = mapper.toEntity(dto);
        entity.setId(id);
        return mapper.toDto(repository.save(entity));
    }

    @Override
    public BusinessDto getByName(String name) {
        if (repository.findByName(name).isEmpty()) return null;
        return mapper.toDto(repository.findByName(name).get());
    }

    @Override
    public void deleteBusiness(Long id) {
        repository.deleteById(id);
    }
}