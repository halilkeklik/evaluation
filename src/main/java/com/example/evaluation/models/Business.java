package com.example.evaluation.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@BatchSize(size = 10)
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private BusinessType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private User owner;


    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> products;


    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;


    @OneToMany(mappedBy = "business", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<BusinessRating> ratings;
}
