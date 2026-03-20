package com.example.FitnessTracker.DAO;

import com.example.FitnessTracker.Model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository <Exercise, Integer> {

}
