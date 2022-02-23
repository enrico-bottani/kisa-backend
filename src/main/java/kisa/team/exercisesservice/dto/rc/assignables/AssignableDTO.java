package kisa.team.exercisesservice.dto.rc.assignables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import lombok.*;

@Getter
@ToString
public class AssignableDTO {
    public AssignableDTO(){
        this.type = AssignableType.Undefined.toString();
    }
    protected String type;
}
