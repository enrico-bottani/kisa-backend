package kisa.team.exercisesservice.model.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ANSWER_SHEET_ITEM")
public class AnswerSheetItem {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )

    @Column(name = "ID", updatable = false)
    int id;
    int givenAnswerID;
    int correctAnswerID;
    int status; // 0 = not submitted, 1 = correct, 2 wrong
}
