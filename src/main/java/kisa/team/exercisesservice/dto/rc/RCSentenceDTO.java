package kisa.team.exercisesservice.dto.rc;

import kisa.team.exercisesservice.dto.TodoDTO;
import kisa.team.exercisesservice.model.assignable.Assignable;
import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class RCSentenceDTO extends TodoDTO {
    List<Assignable> assignables;
}
