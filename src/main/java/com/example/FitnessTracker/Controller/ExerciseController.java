package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.Model.Exercise;
import com.example.FitnessTracker.Model.Workout;
import com.example.FitnessTracker.Service.ExerciseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class ExerciseController {

    private ExerciseService exerciseService;

    ExerciseController(ExerciseService theService) {
        exerciseService = theService;
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hello cruel world";
    }

    @GetMapping("/{exerciseId}")
    public Exercise getExercise(@PathVariable int exerciseId) {

        Exercise theExercise = exerciseService.findById(exerciseId);

        if (theExercise == null) {
            throw new RuntimeException("Exercise with id: " + exerciseId + " was not found");
        }
        return theExercise;
    }

    @PostMapping("/exercises")
    public Exercise addExercise(@RequestBody Exercise theExercise){

        theExercise.setExerciseId(0);

        Exercise exerciseDB = exerciseService.save(theExercise);

        return exerciseDB;
    }
}
