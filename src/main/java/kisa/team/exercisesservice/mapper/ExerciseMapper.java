package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.model.rc.Exercise;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ExerciseMapper {
    public static ExerciseDto map(Exercise e) {
        return ExerciseDto.builder()
                .id(e.getId())
                .title(e.getTitle())
                .todos(e.getTodos().stream().map(TodoMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }

    public static Exercise map(ExerciseDto e) {
        return Exercise.builder().id(e.getId())
                .title(e.getTitle())
                .todos(e.getTodos().stream().map(TodoMapper::map)
                        .collect(Collectors.toList()))
                .build();
    }
}
