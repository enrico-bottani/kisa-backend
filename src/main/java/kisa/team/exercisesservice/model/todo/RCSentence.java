package kisa.team.exercisesservice.model.todo;

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
    @OneToMany
    @JoinColumn(name = "SENTENCE_ID", referencedColumnName = "ID")
    List<AnswerSheetItem> answerSheet;
    String type = TodoType.RC_SENTENCE_TYPE.toString();
}
