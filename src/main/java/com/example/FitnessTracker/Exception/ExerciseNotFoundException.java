package com.example.FitnessTracker.Exception;

public class ExerciseNotFoundException extends RuntimeException{
    public ExerciseNotFoundException(String message) {
        super(message);
    }

    public ExerciseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExerciseNotFoundException(Throwable cause) {
        super(cause);
    }
}
