package com.example.FitnessTracker.Repository;

import com.example.FitnessTracker.Entities.exerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface exerciseRepository extends JpaRepository<exerciseEntity, Integer> {
}
