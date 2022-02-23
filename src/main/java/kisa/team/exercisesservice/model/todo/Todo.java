package kisa.team.exercisesservice.model.todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "TODO__")
@Inheritance(strategy = InheritanceType.JOINED)
public class Todo {

    public Todo(long id,int position){
        this.id = id;
        this.position = position;
    }

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )

    @Column(name = "ID", updatable = false)
    long id;
    int position;
    private final String type=TodoType.TODO.toString();
}

