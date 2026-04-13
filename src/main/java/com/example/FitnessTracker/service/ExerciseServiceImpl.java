package com.example.FitnessTracker.service;

import com.example.FitnessTracker.model.dto.ExerciseDTO;
import com.example.FitnessTracker.entities.ExerciseEntity;
import com.example.FitnessTracker.exception.ExerciseNotFoundException;
import com.example.FitnessTracker.model.mapper.ExerciseMapper;
import com.example.FitnessTracker.repository.ExerciseRepository;
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
    private ExerciseMapper entityMapper;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository theExerciseRepository, ObjectMapper objectMapper, ExerciseMapper mapper) {
        this.theExerciseRepository = theExerciseRepository;
        this.objectMapper = objectMapper;
        this.entityMapper = mapper;
    }

    @Override
    public ExerciseDTO exerciseToDTO(ExerciseEntity theExerciseEntity) {
        return entityMapper.exerciseToExerciseDTO(theExerciseEntity);
    }

    @Override
    public ExerciseEntity DTOtoExercise(ExerciseDTO theExerciseDTO) {
        return entityMapper.exerciseDTOToExercise(theExerciseDTO);
    }

    @Override
    public void validateObjectPresenceInDb(ExerciseDTO exerciseDTO) {
    }

    @Override
    public void saveNewExercise(ExerciseEntity theExerciseEntity) {
        theExerciseEntity.setExerciseId(0);
        theExerciseRepository.save(theExerciseEntity);
    }

    @Override
    public ExerciseDTO findById(int theId) {

        ExerciseEntity theExerciseEntity = theExerciseRepository.findById(theId)
                .orElseThrow(() -> new ExerciseNotFoundException("Exercise id not found " + theId));

        if ((theId < 0) || (theId > 999)) {
            throw new ExerciseNotFoundException("Exercise not found " + theId);
        }
        ExerciseDTO theExerciseDTO = entityMapper.exerciseToExerciseDTO(theExerciseEntity);
        return theExerciseDTO;
    }

    @Override
    public List<ExerciseDTO> findAll() {
        List<ExerciseEntity> exercisesList = theExerciseRepository.findAll();
        List<ExerciseDTO> exerciseDTOList = new ArrayList<>();

        for (ExerciseEntity exerciseEntity : exercisesList) {
            exerciseDTOList.add(exerciseToDTO(exerciseEntity));
        }
        return exerciseDTOList;
    }

    @Transactional
    @Override
    public void updateExercise(int exerciseId,
                               Map<String, Object> patchPayload) {

        Optional<ExerciseEntity> exerciseBeingUpdated = theExerciseRepository.findById(exerciseId);

        if (patchPayload.containsKey("exerciseId")) {
            throw new RuntimeException("Exercise Id not allowed in request body " + exerciseId);
        }
        ExerciseEntity original = exerciseBeingUpdated.get();
        ExerciseEntity patchedExerciseEntity;
        try {
            patchedExerciseEntity = objectMapper.updateValue(original, patchPayload);
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            throw new RuntimeException("Failed to apply patch payload", e);
        }
        theExerciseRepository.save(patchedExerciseEntity);
    }

    @Override
    public void delete(Integer exerciseId) {
        ExerciseEntity tempExerciseEntity = theExerciseRepository.getReferenceById(exerciseId);
        theExerciseRepository.delete(tempExerciseEntity);
    }
}
