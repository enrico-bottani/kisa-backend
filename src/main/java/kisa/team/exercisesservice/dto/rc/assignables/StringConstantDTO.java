package kisa.team.exercisesservice.dto.rc.assignables;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import lombok.*;

@Getter
@ToString
public class StringConstantDTO extends AssignableDTO {
    public StringConstantDTO(){
        super();
    }
    public StringConstantDTO(String type, String value){
        super(type);
        this.value = value;
    }
    String value;
}
