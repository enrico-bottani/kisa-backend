package kisa.team.exercisesservice.model.rc.assignable.answerable;

import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.rc.assignable.AssignableType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode
@Data
@NoArgsConstructor
@Entity
@Table(name = "ASSIGN_SINGLE_CHOICE_ANSWERABLE")
public class RCAnswerable extends Assignable {
    public RCAnswerable(int _order, List<RCAnswerableItem> choices){
        this._order = _order;
        this.choices = choices;
    }

    @OneToMany
    @JoinColumn(name = "SINGLE_CHOICE_ANSWERABLE", referencedColumnName = "ID")
    List<RCAnswerableItem> choices;
    private String type= AssignableType.RC_ANSWERABLE.toString();
}
