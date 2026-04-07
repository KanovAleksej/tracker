package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.Repository.ExerciseRepository;
import com.example.FitnessTracker.DTO.ExerciseDTO;
import com.example.FitnessTracker.Exception.ExerciseNotFoundException;
import com.example.FitnessTracker.Mapper.ExerciseMapper;
import com.example.FitnessTracker.Model.Exercise;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ExerciseServiceImpl implements ExerciseService {


    private ExerciseRepository theExerciseRepository;
    private ObjectMapper objectMapper;
    private ExerciseMapper mapper;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository theExerciseRepository, ObjectMapper objectMapper, ExerciseMapper mapper) {
        this.theExerciseRepository = theExerciseRepository;
        this.objectMapper = objectMapper;
        this.mapper = mapper;
    }

    @Override
    public ExerciseDTO exerciseToDTO(Exercise theExercise) {
        return mapper.exerciseToExerciseDTO(Optional.ofNullable(theExercise));
    }

    @Override
    public Exercise DTOtoExercise(ExerciseDTO theExerciseDTO) {
        return mapper.exerciseDTOToExercise(theExerciseDTO);
    }

    @Transactional
    @Override
    public void save(Exercise theExercise) {
        theExercise.setExerciseId(0);
        theExerciseRepository.save(theExercise);
    }

    @Override
    public ExerciseDTO findById(int theId) {

        Optional<Exercise> theExercise = theExerciseRepository.findById(theId);

        if (!theExercise.isPresent()){
            throw new ExerciseNotFoundException("Exercise id not found " + theId);
        }
        if ((theId < 0) || (theId > 99)){
            throw new ExerciseNotFoundException("Exercise not found " + theId);
        }
        ExerciseDTO theExerciseDTO = mapper.exerciseToExerciseDTO(theExercise);
        return theExerciseDTO;
    }

    @Override
    public List<ExerciseDTO> findAll() {
        List<Exercise> exercisesList = theExerciseRepository.findAll();
        List<ExerciseDTO> exerciseDTOList = new ArrayList<>();

        for (Exercise exercise : exercisesList) {
            exerciseDTOList.add(exerciseToDTO(exercise));
        }
        return exerciseDTOList;
    }

    @Transactional
    @Override
    public void update(int exerciseId,
                       Map<String, Object> patchPayload) {

        Optional<Exercise> exerciseBeingUpdated = theExerciseRepository.findById(exerciseId);

        if (patchPayload.containsKey("exerciseId")) {
            throw new RuntimeException("Exercise Id not allowed in request body " + exerciseId);
        }
        Exercise original = exerciseBeingUpdated.get();
        Exercise patchedExercise;
        try {
            patchedExercise = objectMapper.updateValue(original, patchPayload);
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            throw new RuntimeException("Failed to apply patch payload", e);
        }
        theExerciseRepository.save(patchedExercise);
    }

    @Transactional
    @Override
    public void delete(Integer exerciseId) {
        Exercise tempExercise = theExerciseRepository.getReferenceById(exerciseId);

        theExerciseRepository.delete(tempExercise);

    }
}
