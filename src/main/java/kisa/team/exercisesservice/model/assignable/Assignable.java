package kisa.team.exercisesservice.model.assignable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ASSIGN__")
public class Assignable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Long id;
    private String type="none";
}
