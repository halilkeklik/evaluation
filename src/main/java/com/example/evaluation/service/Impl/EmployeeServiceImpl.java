package com.example.evaluation.service.Impl;

import com.example.evaluation.dtos.EmployeeDto;
import com.example.evaluation.mapper.EmployeeMapper;
import com.example.evaluation.models.Employee;
import com.example.evaluation.repository.EmployeeRepository;
import com.example.evaluation.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public EmployeeServiceImpl(EmployeeRepository repository, EmployeeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
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
        return repository.findById(id).map(mapper::toDto).orElse(null);
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