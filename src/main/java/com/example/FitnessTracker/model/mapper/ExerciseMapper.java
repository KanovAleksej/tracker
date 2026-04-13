package com.example.FitnessTracker.model.mapper;

import com.example.FitnessTracker.model.dto.ExerciseDTO;
import com.example.FitnessTracker.entities.ExerciseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    ExerciseDTO exerciseToExerciseDTO(ExerciseEntity theExerciseEntity);

    ExerciseEntity exerciseDTOToExercise(ExerciseDTO theExerciseDTO);
}
