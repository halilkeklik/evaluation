package com.example.evaluation.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @ManyToOne
    private Business business;

    @OneToMany(mappedBy = "employee")
    private List<EmployeeRating> ratings;
}

