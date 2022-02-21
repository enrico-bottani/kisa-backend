package kisa.team.exercisesservice.repository;

import kisa.team.exercisesservice.model.assignable.answerable.SingleChoiceSentenceChoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleChoiceSentenceChoiceRepository extends JpaRepository<SingleChoiceSentenceChoice, Long> {
}
