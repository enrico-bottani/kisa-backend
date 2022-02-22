package kisa.team.exercisesservice.dto.rc;

import kisa.team.exercisesservice.dto.TodoDTO;
import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RCSentenceDTO extends TodoDTO {
    List<AssignableDTO> assignables;
}
