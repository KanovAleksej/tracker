package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.Model.DTO.exerciseDTO;
import com.example.FitnessTracker.Entities.exerciseEntity;

import java.util.List;
import java.util.Map;

public interface exerciseService {

    void saveNewExercise(exerciseEntity theExerciseEntity);

    exerciseDTO findById(int theId);

    List<exerciseDTO> findAll();

    void updateExercise(int exerciseId,
                        Map<String, Object> patchPayload);

    void delete(Integer exerciseId);

    exerciseDTO exerciseToDTO(exerciseEntity theExerciseEntity);
    exerciseEntity DTOtoExercise(exerciseDTO theExerciseDTO);
}
