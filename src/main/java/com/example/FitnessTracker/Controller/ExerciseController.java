package com.example.FitnessTracker.Controller;

import com.example.FitnessTracker.DAO.ExerciseDAOImpl;
import com.example.FitnessTracker.Model.Exercise;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class ExerciseController {

    private ExerciseDAOImpl exerciseDaoImpl;

    public ExerciseController(ExerciseDAOImpl exerciseDaoImpl) {
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

        if (theExercise == null) {
            throw new RuntimeException("Exercise with id: " + exerciseId + " was not found");
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
                               @RequestBody Exercise theExercise){

        exerciseDaoImpl.update(exerciseId,theExercise);
    }
}
