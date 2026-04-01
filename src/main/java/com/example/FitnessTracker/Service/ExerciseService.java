package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.Model.Exercise;

import java.util.List;

public interface ExerciseService {

    void save(Exercise theExercise);

    Exercise findById(int theId);

    List<Exercise> findAll();

    void update(Integer exerciseId, Exercise theExercise);

    void delete(Integer exerciseId);
}
