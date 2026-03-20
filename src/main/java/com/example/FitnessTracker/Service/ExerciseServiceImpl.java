package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.DAO.ExerciseRepository;
import com.example.FitnessTracker.Model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository theRepository) {
        exerciseRepository = theRepository;
    }

    @Override
    public Exercise findById(int theId) {
        Optional<Exercise> result = exerciseRepository.findById(theId);
        Exercise tempExercise = null;

        if (result.isPresent()) {
            tempExercise = result.get();
        } else {
            throw new RuntimeException("Exercise with id " + theId + " was not found");
        }
        return tempExercise;
    }

    @Override
    public List<Exercise> findAll() {
       return exerciseRepository.findAll();
    }

    @Override
    public Exercise save(Exercise theExercise) {
        exerciseRepository.save(theExercise);
        System.out.println("Exercise saved successfully !");
        return theExercise;
    }

}
