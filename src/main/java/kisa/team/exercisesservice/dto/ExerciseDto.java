package kisa.team.exercisesservice.dto;

import kisa.team.exercisesservice.model.sentence.Todo;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ExerciseDto {
    private long id;
    private String title;
    private List<Todo> todos;
}
