package com.example.FitnessTracker.Model.DTO;

public class exerciseDTO {

    private int exerciseId;
    private String name;
    private int repCount;
    private int previousWorkoutRepCount;


    public exerciseDTO(){};

    public exerciseDTO(String name, int repCount, int previousWorkoutRepCount) {
        this.name = name;
        this.repCount = repCount;
        this.previousWorkoutRepCount = previousWorkoutRepCount;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }

    public int getPreviousWorkoutRepCount() {
        return previousWorkoutRepCount;
    }

    public void setPreviousWorkoutRepCount(int previousWorkoutRepCount) {
        this.previousWorkoutRepCount = previousWorkoutRepCount;
    }
}
