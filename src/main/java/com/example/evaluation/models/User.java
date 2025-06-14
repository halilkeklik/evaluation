package com.example.evaluation.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    @OneToMany(mappedBy = "owner")

    private List<Business> ownedBusinesses;
    @OneToMany(mappedBy = "user")

    private List<BusinessRating> businessRatings;

    @OneToMany(mappedBy = "user")
    private List<ProductRating> productRatings;

    @OneToMany(mappedBy = "user")
    private List<EmployeeRating> employeeRatings;
}
