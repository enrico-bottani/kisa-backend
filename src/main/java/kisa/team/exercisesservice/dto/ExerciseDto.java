package kisa.team.exercisesservice.dto;

import kisa.team.exercisesservice.model.sentence.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto {
    private long id;
    private String title;
    private List<TodoDTO> todos;
}
