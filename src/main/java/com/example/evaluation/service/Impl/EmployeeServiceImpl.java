    package com.example.evaluation.service.Impl;

    import com.example.evaluation.dtos.EmployeeDto;
    import com.example.evaluation.mapper.BusinessMapper;
    import com.example.evaluation.mapper.EmployeeMapper;
    import com.example.evaluation.models.Employee;
    import com.example.evaluation.repository.EmployeeRepository;
    import com.example.evaluation.service.EmployeeService;
    import com.example.evaluation.service.RatingTypeMappingService;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {

        private final EmployeeRepository repository;
        private final EmployeeMapper mapper;
        private final RatingTypeMappingService ratingTypeMappingService;

        public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper, RatingTypeMappingService ratingTypeMappingService) {
            this.repository = repository;
            this.mapper = mapper;
            this.ratingTypeMappingService = ratingTypeMappingService;
        }

        @Override
        public EmployeeDto createEmployee(EmployeeDto dto) {
            Employee entity = mapper.toEntity(dto);
            return mapper.toDto(repository.save(entity));
        }

        @Override
        public List<EmployeeDto> getAllEmployees() {
            return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
        }

        @Override
        public EmployeeDto getEmployeeById(Long id) {

            EmployeeDto dto= repository.findById(id).map(mapper::toDto).orElse(null);
            assert dto != null;
            dto.setAvgRating(ratingTypeMappingService.findAverageRatingByEmployeeId(id));
            return dto;
        }

        @Override
        public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
            if (!repository.existsById(id)) return null;
            Employee entity = mapper.toEntity(dto);
            entity.setId(id);
            return mapper.toDto(repository.save(entity));
        }

        @Override
        public void deleteEmployee(Long id) {
            repository.deleteById(id);
        }
    }