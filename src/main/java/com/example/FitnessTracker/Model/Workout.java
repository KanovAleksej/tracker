package com.example.FitnessTracker.Model;

import com.example.FitnessTracker.Enums.Difficulty;
import jakarta.persistence.Column;

public class Workout {

    @Column(name = "difficulty")
    Difficulty difficulty = Difficulty.WORKING;
}
