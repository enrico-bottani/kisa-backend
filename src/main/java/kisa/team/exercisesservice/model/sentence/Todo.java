package kisa.team.exercisesservice.model.sentence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "TODO__")
@Inheritance(strategy = InheritanceType.JOINED)
public class Todo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )

    @Column(name = "ID", updatable = false)
    int id;
    String type="none";
}
