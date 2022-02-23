package kisa.team.exercisesservice.model.rc.assignable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data

@EqualsAndHashCode
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
    protected Long id;
    protected int _order;
    private final String type = AssignableType.Undefined.toString();

}
