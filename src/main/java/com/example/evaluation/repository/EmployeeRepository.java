package com.example.evaluation.repository;

import com.example.evaluation.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> { }