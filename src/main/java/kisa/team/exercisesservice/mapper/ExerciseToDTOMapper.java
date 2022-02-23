package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.model.Exercise;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExerciseToDTOMapper {
    public ExerciseDto map(Exercise e){
        return ExerciseDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .todos(e.getTodos().stream().map(TodoToDTOMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
