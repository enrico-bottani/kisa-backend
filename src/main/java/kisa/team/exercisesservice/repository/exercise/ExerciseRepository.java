package kisa.team.exercisesservice.repository.exercise;

import kisa.team.exercisesservice.model.rc.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
    Optional<Exercise> getExerciseById(long id);
    List<Exercise> getExercisesByTitleContains(String title);
}
