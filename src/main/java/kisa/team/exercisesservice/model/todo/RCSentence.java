package kisa.team.exercisesservice.model.todo;

import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data


@Entity
@Table(name = "TODO_RC_SENTENCE")
public class RCSentence extends Todo {
    public RCSentence(long id,int position,
                      List<Assignable> assignables,
                      List<AnswerSheetItem> answerSheet){
        super(id,position);
        this.assignables = assignables;
        this.answerSheet = answerSheet;
    }

    int number;
    @OneToMany
    @JoinColumn(name = "SENTENCE_ID", referencedColumnName = "ID")
    List<Assignable> assignables;
    @OneToMany
    @JoinColumn(name = "SENTENCE_ID", referencedColumnName = "ID")
    List<AnswerSheetItem> answerSheet;
    String type = TodoType.RC_SENTENCE_TYPE.toString();
}
