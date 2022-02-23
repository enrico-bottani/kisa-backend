package kisa.team.exercisesservice.repository;

import kisa.team.exercisesservice.model.assignable.Assignable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignableRepository extends JpaRepository<Assignable, Long> {
}
