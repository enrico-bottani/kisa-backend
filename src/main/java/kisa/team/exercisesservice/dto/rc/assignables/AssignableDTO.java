package kisa.team.exercisesservice.dto.rc.assignables;

import kisa.team.exercisesservice.model.rc.assignable.AssignableType;
import lombok.*;

@Getter
@ToString
public class AssignableDTO {
    public AssignableDTO(){
        this.type = AssignableType.Undefined.toString();
    }
    protected String type;
}
