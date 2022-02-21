package kisa.team.exercisesservice.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TodoDTO {
    long id;
    String type;
}
