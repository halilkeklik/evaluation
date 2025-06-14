package com.example.evaluation.models;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
public class EmployeeRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Employee employee;

    @OneToMany(mappedBy = "employeeRating", cascade = CascadeType.ALL)
    private List<RatingTypeMapping> ratingTypes;

    private String comment;
}