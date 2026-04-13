package com.example.FitnessTracker.controller;

import com.example.FitnessTracker.model.dto.ExerciseDTO;
import com.example.FitnessTracker.entities.ExerciseEntity;
import com.example.FitnessTracker.service.ExerciseService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class ExerciseController {

    private ExerciseService exerciseService;

    public ExerciseController(ExerciseService theExerciseService) {
        exerciseService = theExerciseService;
    }

    @GetMapping("/exercises/{exerciseId}")
    public ExerciseDTO getExercise(@PathVariable("exerciseId") Integer exerciseId) {
        return exerciseService.findById(exerciseId);
    }

    @PostMapping("/exercises")
    public void addExercise(@RequestBody ExerciseEntity theExerciseEntity) {
        exerciseService.saveNewExercise(theExerciseEntity);
    }

    @GetMapping("/exercises")
    public List<ExerciseDTO> findAll() {
        return exerciseService.findAll();
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.delete(exerciseId);
    }

    //Put endpoint not in use
    @PutMapping("/exercises/{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId,
                               @RequestBody ExerciseEntity theExerciseEntity) {

        exerciseService.saveNewExercise(theExerciseEntity);
    }

    @PatchMapping("/exercises/{exerciseId}")
    public void patchExercise(@PathVariable("exerciseId") int exerciseId,
                              @RequestBody Map<String, Object> patchPayload) {

        exerciseService.updateExercise(exerciseId, patchPayload);
    }
}
