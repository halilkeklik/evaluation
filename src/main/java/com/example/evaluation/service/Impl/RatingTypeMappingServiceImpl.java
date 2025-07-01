package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.ProductDto;
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

    @Override
    public Double findAverageRatingByProductId(Long id) {
        RatingTypeMappingDto dto = repository.findById(id).map(mapper::toDto).orElse(null);
        if (dto == null) {
            dto = new RatingTypeMappingDto();
            dto.setProductAvgRating(0.0);
            return 0.0;
        }
        Double avg = repository.findAverageRatingByProductId(id);
        dto.setProductAvgRating(avg != null ? avg : 0.0);
        return dto.getProductAvgRating();
    }

    @Override
    public Double findAverageRatingByBusinessId(Long id) {
        RatingTypeMappingDto dto = repository.findById(id).map(mapper::toDto).orElse(null);

        if (dto == null) {
            dto = new RatingTypeMappingDto(); // yeni nesne oluştur
            dto.setBusinessRatingId(0L); // varsayılan veya uygun değer ata
            dto.setBusinessAvgRating(0.0); // varsayılan puan
            return 0.0; // ya da uygun varsayılan değer
        }

        Double avg = repository.findAverageRatingByBusinessId(id);
        dto.setBusinessAvgRating(avg);

        return dto.getBusinessAvgRating();
    }

    @Override
    public long getTotalRatingCount() {
        return repository.count();
    }

    @Override
    public Double findAverageRatingByEmployeeId(Long id) {
        RatingTypeMappingDto dto = repository.findById(id).map(mapper::toDto).orElse(null);
        if (dto == null) {
            // dto null ise yeni nesne oluşturup varsayılan değer döndür
            dto = new RatingTypeMappingDto();
            dto.setEmployeeAvgRating(0.0);
            return 0.0;
        }
        Double avg = repository.findAverageRatingByEmployeeId(id);
        dto.setEmployeeAvgRating(avg != null ? avg : 0.0);
        return dto.getEmployeeAvgRating();
    }

}