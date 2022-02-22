package kisa.team.exercisesservice.dto.rc.assignables;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import lombok.*;

@Getter
@ToString
public class RCAnswerableDTO extends AssignableDTO {

    public RCAnswerableDTO(){super();}
    public RCAnswerableDTO(String type, String[] choices){
        super(type);
        this.choices = choices;
    }
    String[] choices;
}
