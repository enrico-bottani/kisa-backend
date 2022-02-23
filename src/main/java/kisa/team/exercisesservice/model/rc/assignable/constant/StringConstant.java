package kisa.team.exercisesservice.model.rc.assignable.constant;

import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.rc.assignable.AssignableType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ASSIGN_STRING_CONSTANT")
public class StringConstant extends Assignable {

    public StringConstant(int _order, String value){
        this._order = _order;
        this.value = value;
    }

    String value;
    private final String type = AssignableType.STRING.toString();
}
