package com.example.FitnessTracker.Entity;

import com.example.FitnessTracker.Enums.Difficulty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Id;
import java.util.List;

public class Exercise {

    private int exId;

    private String name;

    Difficulty difficulty = Difficulty.WORKING;

    private int setCount;
    private int previousRepCount;
    List<Set> sets;

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


    public int getPreviousRepCount() {
        return previousRepCount;
    }

    public void setPreviousRepCount(int previousRepCount) {
        this.previousRepCount = previousRepCount;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", difficulty=" + difficulty +
                ", setCount=" + setCount +
                ", previousRepCount=" + previousRepCount +
                '}';
    }
}
