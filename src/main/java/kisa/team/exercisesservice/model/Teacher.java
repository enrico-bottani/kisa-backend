package kisa.team.exercisesservice.model;

import kisa.team.exercisesservice.model.rc.Exercise;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "TEACHER",
        uniqueConstraints = {
                @UniqueConstraint(name="UNIQUE_PROFILE_NAME", columnNames = "PROFILE_NAME")
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
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
    @Column(name = "PROFILE_NAME", nullable = false)
    private String profileName;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID")
    private List<Exercise> exercises;
}
