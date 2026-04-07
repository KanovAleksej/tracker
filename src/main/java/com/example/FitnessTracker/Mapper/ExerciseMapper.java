package com.example.FitnessTracker.Mapper;

import com.example.FitnessTracker.DTO.ExerciseDTO;
import com.example.FitnessTracker.Model.Exercise;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ExerciseMapper {
    ExerciseMapper INSTANCE = Mappers.getMapper(ExerciseMapper.class);

    ExerciseDTO exerciseToExerciseDTO(Optional<Exercise> theExercise);

    Exercise exerciseDTOToExercise(ExerciseDTO theExerciseDTO);
}
