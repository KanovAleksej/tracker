package com.example.FitnessTracker.Service;


import com.example.FitnessTracker.Model.Exercise;

import java.util.List;

public interface ExerciseService {
    Exercise findById(int theId);
    List<Exercise> findAll();
    Exercise save(Exercise theExercise);
}
