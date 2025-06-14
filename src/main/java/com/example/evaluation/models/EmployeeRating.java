package com.example.evaluation.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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