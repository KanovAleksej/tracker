package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.DTO.ExerciseDTO;
import com.example.FitnessTracker.Model.Exercise;

import java.util.List;
import java.util.Map;

public interface ExerciseService {

    void save(Exercise theExercise);

    ExerciseDTO findById(int theId);

    List<ExerciseDTO> findAll();

    void update(int exerciseId,
                Map<String, Object> patchPayload);

    void delete(Integer exerciseId);

    ExerciseDTO exerciseToDTO(Exercise theExercise);
    Exercise DTOtoExercise(ExerciseDTO theExerciseDTO);
}
