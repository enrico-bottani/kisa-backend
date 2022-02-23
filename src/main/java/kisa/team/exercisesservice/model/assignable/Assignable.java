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

    public Assignable(Long id, String type){
        this.id = id;
        this.type = type;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Long id;
    private String type="none";

    public static String RCAnswerable = "RCA";
    public static String String = "STR";
    public static String Undefined = "UND";
}
