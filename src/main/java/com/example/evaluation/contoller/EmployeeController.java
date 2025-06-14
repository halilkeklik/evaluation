package com.example.evaluation.contoller;

import com.example.evaluation.dtos.EmployeeDto;
import com.example.evaluation.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto dto) {
        return service.createEmployee(dto);
    }

    @GetMapping
    public List<EmployeeDto> getAll() {
        return service.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeDto update(@PathVariable Long id, @RequestBody EmployeeDto dto) {
        return service.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployee(id);
    }
}
