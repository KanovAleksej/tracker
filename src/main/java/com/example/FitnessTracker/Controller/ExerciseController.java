package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.DAO.ExerciseDAOImpl;
import com.example.FitnessTracker.Exception.ExerciseNotFoundException;
import com.example.FitnessTracker.Model.Exercise;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
public class ExerciseController {

    private ExerciseDAOImpl exerciseDaoImpl;
    private JsonMapper jsonMapper;

    public ExerciseController(ExerciseDAOImpl exerciseDaoImpl, JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
        this.exerciseDaoImpl = exerciseDaoImpl;
    }

    @GetMapping("/hi")
    public String hello() {
        return "Hello cruel world";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/exercises/{exerciseId}")
    public Exercise getExercise(@PathVariable("exerciseId") Integer exerciseId) {

        Exercise theExercise = exerciseDaoImpl.findById(exerciseId);

        if ((theExercise == null) || (exerciseId < 0) || (exerciseId > 99)) {
            throw new ExerciseNotFoundException("Exercise not found " + exerciseId);
        }
        return theExercise;
    }

    @PostMapping("/exercises")
    public void addExercise(@RequestBody Exercise theExercise) {

        theExercise.setExerciseId(0);
        exerciseDaoImpl.save(theExercise);
        System.out.println("Id was set to " + theExercise.getExerciseId());
    }

    @GetMapping("/exercises")
    public List<Exercise> findAll() {
        return exerciseDaoImpl.findAll();
    }

    @DeleteMapping("/exercises/{exerciseId}")
    public void deleteExercise(@PathVariable("exerciseId") Integer exerciseId) {
        exerciseDaoImpl.delete(exerciseId);
    }

    @PutMapping("/exercises/{exerciseId}")
    public void updateExercise(@PathVariable("exerciseId") Integer exerciseId,
                               @RequestBody Exercise theExercise) {

        exerciseDaoImpl.update(exerciseId, theExercise);
    }

    @PatchMapping("/exercises/{exerciseId}")
    public void patchExercise(@PathVariable ("exerciseId") int exerciseId,
                              @RequestBody Map<String, Object> patchPayload) {

        Exercise tempExercise = exerciseDaoImpl.findById(exerciseId);

        if (tempExercise == null){
            throw new ExerciseNotFoundException("Exercise id not found " +  exerciseId);
        }
        if (patchPayload.containsKey("exerciseId")) {
            throw new RuntimeException("Exercise Id not allowed in request body " + exerciseId);
        }
        Exercise patchedExercise = jsonMapper.updateValue(tempExercise, patchPayload);
        exerciseDaoImpl.save(patchedExercise);

        System.out.println(patchedExercise);
    }
}
