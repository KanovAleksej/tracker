package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.DTO.ExerciseDTO;
import com.example.FitnessTracker.Model.Exercise;
import com.example.FitnessTracker.Service.ExerciseService;
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

    @GetMapping("/hi")
    public String hello() {
        return "Hello cruel world";
    }

    @GetMapping("/exercises/{exerciseId}")
    public ExerciseDTO getExercise(@PathVariable("exerciseId") Integer exerciseId) {
        return exerciseService.findById(exerciseId);
    }

    @PostMapping("/exercises")
    public void addExercise(@RequestBody Exercise theExercise) {
        exerciseService.save(theExercise);
    }

    @GetMapping("/exercises")
    public List<ExerciseDTO> findAll() {
        return exerciseService.findAll();
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.delete(exerciseId);
    }

    @PutMapping("/exercises/{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId,
                               @RequestBody Exercise theExercise) {

        exerciseService.save(theExercise);
    }

    @PatchMapping("/exercises/{exerciseId}")
    public void patchExercise(@PathVariable("exerciseId") int exerciseId,
                              @RequestBody Map<String, Object> patchPayload) {

        exerciseService.update(exerciseId, patchPayload);
    }
}
