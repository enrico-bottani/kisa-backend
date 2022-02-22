package kisa.team.exercisesservice.dto.rc.assignables;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@ToString
public class AssignableDTO {
    public AssignableDTO(){
    }
    public AssignableDTO(String type){
        this.type = type;
    }
    String type;
}
