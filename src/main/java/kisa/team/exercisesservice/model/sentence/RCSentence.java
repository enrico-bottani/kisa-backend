package kisa.team.exercisesservice.model.sentence;

import kisa.team.exercisesservice.model.assignable.Assignable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Table(name = "TODO_RC_SENTENCE")
public class RCSentence extends Todo {
    int number;

    @OneToMany
    @JoinColumn(name = "SENTENCE_ID", referencedColumnName = "ID")
    List<Assignable> assignables;
    String type="RCT";
}
