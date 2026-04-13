package com.example.FitnessTracker.service;

import com.example.FitnessTracker.model.dto.ExerciseDTO;
import com.example.FitnessTracker.entities.ExerciseEntity;

import java.util.List;
import java.util.Map;

public interface ExerciseService {

    void validateObjectPresenceInDb(ExerciseDTO exerciseDTO);

    void saveNewExercise(ExerciseEntity theExerciseEntity);

    ExerciseDTO findById(int theId);

    List<ExerciseDTO> findAll();

    void updateExercise(int exerciseId,
                        Map<String, Object> patchPayload);

    void delete(Integer exerciseId);

    ExerciseDTO exerciseToDTO(ExerciseEntity theExerciseEntity);
    ExerciseEntity DTOtoExercise(ExerciseDTO theExerciseDTO);
}
