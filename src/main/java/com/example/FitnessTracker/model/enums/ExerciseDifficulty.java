package com.example.FitnessTracker.model.enums;

public enum ExerciseDifficulty {
    LIGHT,
    WORKING,
    HEAVY;

    int calculateDifficulty(int workingWeight){
        return switch (this){
            case HEAVY -> (int) Math.round(workingWeight * 1.25);
            case LIGHT -> (int) Math.round(workingWeight * 0.75);
            case WORKING -> workingWeight;
        };
    }
}
