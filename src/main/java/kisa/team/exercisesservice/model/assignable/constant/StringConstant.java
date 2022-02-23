package kisa.team.exercisesservice.model.assignable.constant;

import kisa.team.exercisesservice.model.assignable.Assignable;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ASSIGN_STRING_CONSTANT")
public class StringConstant extends Assignable {

    public StringConstant(Long id, String value){
        super(id);
        this.value = value;
    }

    String value;
    private final String type = AssignableType.STRING.toString();
}
