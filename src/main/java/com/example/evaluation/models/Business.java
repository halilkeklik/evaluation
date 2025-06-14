package com.example.evaluation.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Business {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BusinessType type;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @OneToMany(mappedBy = "business")
    private List<Product> products;

    @OneToMany(mappedBy = "business")
    private List<Employee> employees;

    @OneToMany(mappedBy = "business")
    private List<BusinessRating> ratings;
}
