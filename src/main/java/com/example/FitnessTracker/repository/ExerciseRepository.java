package com.example.FitnessTracker.repository;

import com.example.FitnessTracker.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Integer> {
}
