package com.example.FitnessTracker.Model;

import com.example.FitnessTracker.Enums.Difficulty;

import java.util.List;

public class Exercise {

    private int exerciseId;
    private String name;
    Difficulty difficulty = Difficulty.WORKING;
    private int repCount;
    private int previousWorkoutRepCount;
    private List<Set> sets;

    public Exercise(String name) {
        this(name, 3, 8, 120);
    }

    public Exercise(String name, int repCount) {
        this(name, 3, repCount, 120);
    }

    public Exercise(String name, int setCount, int repCount) {
        this(name, setCount, repCount, 120);
    }

    public Exercise(String name, int setCount, int repCount, int restTimer) {
        this.name = name;
        this.repCount = setCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
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

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", setCount=" + repCount +
                ", previousRepCount=" + previousWorkoutRepCount +
                '}';
    }
}
