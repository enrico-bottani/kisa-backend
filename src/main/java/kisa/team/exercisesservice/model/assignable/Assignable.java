package kisa.team.exercisesservice.model.assignable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Data


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "ASSIGN__")
public class Assignable {

    public Assignable(Long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Long id;
    private final String type = AssignableType.Undefined.toString();

}
