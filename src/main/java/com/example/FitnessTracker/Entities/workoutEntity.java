package com.example.FitnessTracker.Entities;

import com.example.FitnessTracker.Model.Enums.Difficulty;
import jakarta.persistence.Column;

public class workoutEntity {

    @Column(name = "difficulty")
    Difficulty difficulty = Difficulty.WORKING;
}
