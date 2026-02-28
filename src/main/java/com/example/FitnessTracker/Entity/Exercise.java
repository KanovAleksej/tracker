package com.example.FitnessTracker.Entity;

import com.example.FitnessTracker.Enums.Difficulty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Id;

public class Exercise {

    @Id
    @Nonnull
    private String name;

    Difficulty difficulty = Difficulty.WORKING;

    private int setCount;

    private int repCount;

    private int previousRepCount;

    private int restTimer;

    private String note;

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
        this.setCount = setCount;
        this.repCount = repCount;
        this.restTimer = restTimer;
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

    public int getSetCount() {
        return setCount;
    }

    public void setSetCount(int setCount) {
        this.setCount = setCount;
    }

    public int getRepCount() {
        return repCount;
    }

    public void setRepCount(int repCount) {
        this.repCount = repCount;
    }

    public int getPreviousRepCount() {
        return previousRepCount;
    }

    public void setPreviousRepCount(int previousRepCount) {
        this.previousRepCount = previousRepCount;
    }

    public int getRestTimer() {
        return restTimer;
    }

    public void setRestTimer(int restTimer) {
        this.restTimer = restTimer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", setCount=" + setCount +
                ", repCount=" + repCount +
                ", previousRepCount=" + previousRepCount +
                ", restTimer=" + restTimer +
                ", note='" + note + '\'' +
                '}';
    }
}
