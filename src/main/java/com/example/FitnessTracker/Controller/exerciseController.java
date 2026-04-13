package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.Model.DTO.exerciseDTO;
import com.example.FitnessTracker.Entities.exerciseEntity;
import com.example.FitnessTracker.Service.exerciseService;
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
public class exerciseController {

    private exerciseService exerciseService;

    public exerciseController(exerciseService theExerciseService) {
        exerciseService = theExerciseService;
    }

    @GetMapping("/exercises/{exerciseId}")
    public exerciseDTO getExercise(@PathVariable("exerciseId") Integer exerciseId) {
        return exerciseService.findById(exerciseId);
    }

    @PostMapping("/exercises")
    public void addExercise(@RequestBody exerciseEntity theExerciseEntity) {
        exerciseService.saveNewExercise(theExerciseEntity);
    }

    @GetMapping("/exercises")
    public List<exerciseDTO> findAll() {
        return exerciseService.findAll();
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.delete(exerciseId);
    }

    //Put endpoint not in use
    @PutMapping("/exercises/{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId,
                               @RequestBody exerciseEntity theExerciseEntity) {

        exerciseService.saveNewExercise(theExerciseEntity);
    }

    @PatchMapping("/exercises/{exerciseId}")
    public void patchExercise(@PathVariable("exerciseId") int exerciseId,
                              @RequestBody Map<String, Object> patchPayload) {

        exerciseService.updateExercise(exerciseId, patchPayload);
    }
}
