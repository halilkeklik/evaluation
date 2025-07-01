package com.example.evaluation.repository;

import com.example.evaluation.models.RatingTypeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RatingTypeMappingRepository extends JpaRepository<RatingTypeMapping, Long> {
    @Query(value = """
    SELECT AVG(rt.rating_value)
    FROM rating_type_mapping rtm
    JOIN rating_type rt ON rtm.rating_type_id = rt.id
    WHERE rtm.employee_rating_id = :employeeId
""", nativeQuery = true)
    Double findAverageRatingByEmployeeId(@Param("employeeId") Long employeeId);

    @Query(value = """
    SELECT AVG(rt.rating_value)
    FROM rating_type_mapping rtm
    JOIN rating_type rt ON rtm.rating_type_id = rt.id
    WHERE rtm.product_rating_id = :productId
""", nativeQuery = true)
    Double findAverageRatingByProductId(@Param("productId") Long productId);

    @Query(value = """
    SELECT AVG(rt.rating_value)
    FROM rating_type_mapping rtm
    JOIN rating_type rt ON rtm.rating_type_id = rt.id
    WHERE rtm.business_rating_id = :businessId
""", nativeQuery = true)
    Double findAverageRatingByBusinessId(@Param("businessId") Long businessId);


}