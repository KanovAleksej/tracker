package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.DAO.ExerciseDAO;
import com.example.FitnessTracker.Model.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    private ExerciseDAO exerciseDAO;

    @Autowired
    public ExerciseServiceImpl(ExerciseDAO theExerciseDAO){
        exerciseDAO = theExerciseDAO;
    }

    @Transactional
    @Override
    public void save(Exercise theExercise) {
        exerciseDAO.save(theExercise);
    }

    @Override
    public Exercise findById(int theId) {
        return exerciseDAO.findById(theId);
    }

    @Override
    public List<Exercise> findAll() {
        return exerciseDAO.findAll();
    }

    @Transactional
    @Override
    public void update(Integer exerciseId, Exercise theExercise) {
        exerciseDAO.update(exerciseId,theExercise);
    }

    @Transactional
    @Override
    public void delete(Integer exerciseId) {
        exerciseDAO.delete(exerciseId);

    }
}
