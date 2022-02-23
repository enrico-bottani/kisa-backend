package kisa.team.exercisesservice.dto.rc;

import kisa.team.exercisesservice.dto.AnswerSheetItemDTO;
import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class RCSentenceDTO extends TodoDTO {
    public RCSentenceDTO(String type,int position,long id,
                         List<AssignableDTO> assignables,
                         List<AnswerSheetItemDTO> answerSheet ){
        super(type,position,id);
        this.assignables = assignables;
        this.answerSheet = answerSheet;

    }
    private List<AssignableDTO> assignables;
    private List<AnswerSheetItemDTO> answerSheet;
}
