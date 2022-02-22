package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.model.Exercise;
import org.springframework.stereotype.Component;

@Component
public class ExerciseToDtoMapper {
    public ExerciseDto map(Exercise e){
        return ExerciseDto.builder().id(e.getId()).title(e.getTitle()).build();
    }
}
