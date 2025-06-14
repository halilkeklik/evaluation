package com.example.evaluation.contoller;

import com.example.evaluation.dtos.EmployeeRatingDto;
import com.example.evaluation.service.EmployeeRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employeeRatings")
public class EmployeeRatingController {

    private final EmployeeRatingService service;

    public EmployeeRatingController(EmployeeRatingService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeRatingDto create(@RequestBody EmployeeRatingDto dto) {
        return service.createEmployeeRating(dto);
    }

    @GetMapping
    public List<EmployeeRatingDto> getAll() {
        return service.getAllEmployeeRatings();
    }

    @GetMapping("/{id}")
    public EmployeeRatingDto getById(@PathVariable Long id) {
        return service.getEmployeeRatingById(id);
    }

    @PutMapping("/{id}")
    public EmployeeRatingDto update(@PathVariable Long id, @RequestBody EmployeeRatingDto dto) {
        return service.updateEmployeeRating(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployeeRating(id);
    }
}
