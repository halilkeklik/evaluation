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
public class BusinessRating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Business business;
    @OneToMany(mappedBy = "businessRating", cascade = CascadeType.ALL)
    private List<RatingTypeMapping> ratingTypes;

    private String comment;
}

