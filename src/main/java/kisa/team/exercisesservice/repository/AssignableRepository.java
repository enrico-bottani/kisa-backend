package kisa.team.exercisesservice.repository;

import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignableRepository extends JpaRepository<Assignable, Long> {
}
