package com.example.FitnessTracker.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exerciseId")
    private int exerciseId;

    @Column(name = "exercise_name", nullable = false)
    private String name;

    @Column(name = "rep_count", nullable = false)
    private int repCount;

    @Column(name = "previous_rep_count")
    private int previousWorkoutRepCount;

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

    @Override
    public String toString() {
        return "Exercise{" +
                "name='" + name + '\'' +
                ", setCount=" + repCount +
                ", previousRepCount=" + previousWorkoutRepCount +
                '}';
    }
}
