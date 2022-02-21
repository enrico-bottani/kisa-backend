package kisa.team.exercisesservice.repository;

import kisa.team.exercisesservice.model.sentence.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
