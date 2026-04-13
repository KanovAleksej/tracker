package com.example.FitnessTracker.Service;

import com.example.FitnessTracker.Model.DTO.exerciseDTO;
import com.example.FitnessTracker.Entities.exerciseEntity;
import com.example.FitnessTracker.Exception.exerciseNotFoundException;
import com.example.FitnessTracker.Model.Mapper.exerciseMapper;
import com.example.FitnessTracker.Repository.exerciseRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class exerciseServiceImpl implements exerciseService {


    private exerciseRepository theExerciseRepository;
    private ObjectMapper objectMapper;
    private exerciseMapper entityMapper;

    @Autowired
    public exerciseServiceImpl(exerciseRepository theExerciseRepository, ObjectMapper objectMapper, exerciseMapper mapper) {
        this.theExerciseRepository = theExerciseRepository;
        this.objectMapper = objectMapper;
        this.entityMapper = mapper;
    }

    @Override
    public exerciseDTO exerciseToDTO(exerciseEntity theExerciseEntity) {
        return entityMapper.exerciseToExerciseDTO(theExerciseEntity);
    }

    @Override
    public exerciseEntity DTOtoExercise(exerciseDTO theExerciseDTO) {
        return entityMapper.exerciseDTOToExercise(theExerciseDTO);
    }

    @Override
    public void saveNewExercise(exerciseEntity theExerciseEntity) {
        theExerciseEntity.setExerciseId(0);
        theExerciseRepository.save(theExerciseEntity);
    }

    @Override
    public exerciseDTO findById(int theId) {

        exerciseEntity theExerciseEntity = theExerciseRepository.findById(theId)
                .orElseThrow(() -> new exerciseNotFoundException("Exercise id not found " + theId));

        if ((theId < 0) || (theId > 999)) {
            throw new exerciseNotFoundException("Exercise not found " + theId);
        }
        exerciseDTO theExerciseDTO = entityMapper.exerciseToExerciseDTO(theExerciseEntity);
        return theExerciseDTO;
    }

    @Override
    public List<exerciseDTO> findAll() {
        List<exerciseEntity> exercisesList = theExerciseRepository.findAll();
        List<exerciseDTO> exerciseDTOList = new ArrayList<>();

        for (exerciseEntity exerciseEntity : exercisesList) {
            exerciseDTOList.add(exerciseToDTO(exerciseEntity));
        }
        return exerciseDTOList;
    }

    @Transactional
    @Override
    public void updateExercise(int exerciseId,
                               Map<String, Object> patchPayload) {

        Optional<exerciseEntity> exerciseBeingUpdated = theExerciseRepository.findById(exerciseId);

        if (patchPayload.containsKey("exerciseId")) {
            throw new RuntimeException("Exercise Id not allowed in request body " + exerciseId);
        }
        exerciseEntity original = exerciseBeingUpdated.get();
        exerciseEntity patchedExerciseEntity;
        try {
            patchedExerciseEntity = objectMapper.updateValue(original, patchPayload);
        } catch (com.fasterxml.jackson.databind.JsonMappingException e) {
            throw new RuntimeException("Failed to apply patch payload", e);
        }
        theExerciseRepository.save(patchedExerciseEntity);
    }

    @Override
    public void delete(Integer exerciseId) {
        exerciseEntity tempExerciseEntity = theExerciseRepository.getReferenceById(exerciseId);
        theExerciseRepository.delete(tempExerciseEntity);
    }
}
