package com.example.FitnessTracker.DAO;

import com.example.FitnessTracker.Model.Exercise;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseDAO {

    void save(Exercise theExercise);

    Exercise findById(Integer theId);

    List<Exercise> findAll();

    void update(Integer exerciseId, Exercise theExercise);

    void delete(Integer exerciseId);
}
