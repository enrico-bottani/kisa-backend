package kisa.team.exercisesservice.model.assignable.answerable;

import kisa.team.exercisesservice.model.assignable.Assignable;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name = "ASSIGN_SINGLE_CHOICE_ANSWERABLE")
public class RCAnswerable extends Assignable {

    public RCAnswerable(Long id, List<RCAnswerableItem> choices){
        super(id);
        this.choices = choices;
    }

    @OneToMany
    @JoinColumn(name = "SINGLE_CHOICE_ANSWERABLE", referencedColumnName = "ID")
    List<RCAnswerableItem> choices;
    private String type= AssignableType.RC_ANSWERABLE.toString();
}
