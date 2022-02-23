package kisa.team.exercisesservice.dto.rc.assignables;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import lombok.*;

@Getter
@ToString
public class StringConstantDTO extends AssignableDTO {
    public StringConstantDTO(){
        super();
    }
    public StringConstantDTO( String value){
        this.value = value;
    }
    String type = AssignableType.STRING.toString();

    String value;
}
