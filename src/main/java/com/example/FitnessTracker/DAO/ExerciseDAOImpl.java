package com.example.FitnessTracker.DAO;

import com.example.FitnessTracker.Model.Exercise;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ExerciseDAOImpl implements ExerciseDAO {

    private EntityManager entityManager;

    @Autowired
    public ExerciseDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void save(Exercise theExercise) {
        entityManager.persist(theExercise);
    }

    @Override
    public Exercise findById(Integer theId) {
        Exercise tempExercise = entityManager.find(Exercise.class, theId);
        return tempExercise;
    }

    @Override
    public List<Exercise> findAll() {
        TypedQuery<Exercise> theQuery = entityManager.createQuery("FROM Exercise", Exercise.class);
        return theQuery.getResultList();
    }

    @Override
    public void update(Integer exerciseId, Exercise theExercise) {
        Exercise tempExercise = entityManager.find(Exercise.class, exerciseId);
        //temp name change for testing purpose
        tempExercise.setName(theExercise.getName());
        entityManager.merge(tempExercise);
    }

    @Override
    public void delete(Integer exerciseId) {
        Exercise tempExercise = entityManager.find(Exercise.class, exerciseId);
        entityManager.remove(tempExercise);
    }
}
