package com.example.FitnessTracker.entities;

import com.example.FitnessTracker.model.enums.ExerciseDifficulty;
import jakarta.persistence.Column;

public class WorkoutEntity {

    @Column(name = "difficulty")
    ExerciseDifficulty difficulty = ExerciseDifficulty.WORKING;
}
