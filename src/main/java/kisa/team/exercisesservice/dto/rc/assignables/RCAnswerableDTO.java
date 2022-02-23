package kisa.team.exercisesservice.dto.rc.assignables;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import lombok.*;

@Getter
@ToString
public class RCAnswerableDTO extends AssignableDTO {

    public RCAnswerableDTO(){
    }
    public RCAnswerableDTO(String[] choices){
        this.choices = choices;
    }
    String type = AssignableType.RC_ANSWERABLE.toString();
    String[] choices;
}
