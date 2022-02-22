package kisa.team.exercisesservice;

import kisa.team.exercisesservice.model.Exercise;
import kisa.team.exercisesservice.model.Teacher;
import kisa.team.exercisesservice.model.assignable.Assignable;
import kisa.team.exercisesservice.model.assignable.answerable.SingleChoiceAnswerable;
import kisa.team.exercisesservice.model.assignable.constant.StringConstant;
import kisa.team.exercisesservice.model.sentence.RCSentence;
import kisa.team.exercisesservice.model.assignable.answerable.SingleChoiceSentenceChoice;
import kisa.team.exercisesservice.model.sentence.Todo;
import kisa.team.exercisesservice.repository.*;
import kisa.team.exercisesservice.repository.exercise.ExerciseRepository;
import kisa.team.exercisesservice.service.ExerciseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ExercisesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExercisesServiceApplication.class, args);
	}
}
