package kisa.team.exercisesservice.model.rc;

import kisa.team.exercisesservice.model.todo.Todo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Builder
@Entity
@Table(name = "EXERCISE")
public class Exercise {
    @Id
    @SequenceGenerator(
            name = "exercise_sequence",
            sequenceName = "exercise_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "exercise_sequence"
    )
    @Column(name = "ID", updatable = false)
    private Long id;
    @Column(name = "TITLE", nullable = false)
    private String title;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "EXERCISE_ID", referencedColumnName = "ID")
    private List<Todo> todos;
}
