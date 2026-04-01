package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.Exception.ExerciseNotFoundException;
import com.example.FitnessTracker.Model.Exercise;
import com.example.FitnessTracker.Service.ExerciseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class ExerciseController {

    private ExerciseService exerciseService;
    private JsonMapper jsonMapper;

    public ExerciseController(ExerciseService theExerciseService, JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
        exerciseService = theExerciseService;
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hello cruel world";
    }

    @GetMapping("/exercises/{exerciseId}")
    public Exercise getExercise(@PathVariable("exerciseId") Integer exerciseId) {

        Exercise theExercise = exerciseService.findById(exerciseId);

        if ((theExercise == null) || (exerciseId < 0) || (exerciseId > 99)) {
            throw new ExerciseNotFoundException("Exercise not found " + exerciseId);
        }
        return theExercise;
    }

    @PostMapping("/exercises")
    public void addExercise(@RequestBody Exercise theExercise) {

        theExercise.setExerciseId(0);
        exerciseService.save(theExercise);
        System.out.println("Id was set to " + theExercise.getExerciseId());
    }

    @GetMapping("/exercises")
    public List<Exercise> findAll() {
        return exerciseService.findAll();
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseService.delete(exerciseId);
    }

    @PutMapping("/exercises/{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId,
                               @RequestBody Exercise theExercise) {

        exerciseService.update(exerciseId, theExercise);
    }

    @PatchMapping("/exercises/{exerciseId}")
    public void patchExercise(@PathVariable("exerciseId") int exerciseId,
                              @RequestBody Map<String, Object> patchPayload) {

        Exercise tempExercise = exerciseService.findById(exerciseId);

        if (tempExercise == null) {
            throw new ExerciseNotFoundException("Exercise id not found " + exerciseId);
        }
        if (patchPayload.containsKey("exerciseId")) {
            throw new RuntimeException("Exercise Id not allowed in request body " + exerciseId);
        }
        Exercise patchedExercise = jsonMapper.updateValue(tempExercise, patchPayload);
        exerciseService.save(patchedExercise);

        System.out.println(patchedExercise);
    }
}
