package com.example.FitnessTracker.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "exercise")
public class exerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exercise_id")
    private int exerciseId;

    @Column(name = "exercise_name", nullable = false)
    private String name;

    @Column(name = "rep_count")
    private int repCount;

    @Column(name = "previous_rep_count")
    private int previousWorkoutRepCount;

    public exerciseEntity(){};

    public exerciseEntity(String name, int repCount, int previousWorkoutRepCount) {
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

    @Override
    public String toString() {
        return "Exercise{" +
                "exerciseId=" + exerciseId +
                ", name='" + name + '\'' +
                ", repCount=" + repCount +
                ", previousWorkoutRepCount=" + previousWorkoutRepCount +
                '}';
    }
}
