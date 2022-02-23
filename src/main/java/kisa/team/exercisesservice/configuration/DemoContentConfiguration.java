package kisa.team.exercisesservice.configuration;

import kisa.team.exercisesservice.model.rc.Exercise;
import kisa.team.exercisesservice.model.Teacher;
import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerableItem;
import kisa.team.exercisesservice.model.rc.assignable.constant.StringConstant;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.repository.AssignableRepository;
import kisa.team.exercisesservice.repository.SingleChoiceSentenceChoiceRepository;
import kisa.team.exercisesservice.repository.TeacherRepository;
import kisa.team.exercisesservice.repository.TodoRepository;
import kisa.team.exercisesservice.repository.exercise.ExerciseRepository;
import kisa.team.exercisesservice.service.ExerciseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DemoContentConfiguration {
    @Bean
    CommandLineRunner commandLineRunner(TeacherRepository teacherRepository,
                                        SingleChoiceSentenceChoiceRepository singleChoiceSentenceChoiceRepository,
                                        AssignableRepository assignableRepository,
                                        TodoRepository singleChoiceSentenceRepository,
                                        ExerciseService exerciseService,
                                        ExerciseRepository exerciseRepository) {
        return args -> {
            RCAnswerableItem RCAnswerableItem = new RCAnswerableItem();
            RCAnswerableItem.setId(1);
            RCAnswerableItem.setValue("We are");
            var choices = new ArrayList<RCAnswerableItem>();
            choices.add(RCAnswerableItem);
            singleChoiceSentenceChoiceRepository.saveAll(choices);

            // BUILD SENTENCE ELEMENTS
            List<Assignable> singleChoiceAnswerables = new ArrayList<>();
            var singleChoiceAnswerable = new RCAnswerable();
            singleChoiceAnswerable.setChoices(choices);
            singleChoiceAnswerables.add(singleChoiceAnswerable);
            var assignable = new StringConstant();
            assignable.setValue("Test");
            singleChoiceAnswerables.add(assignable);
            assignableRepository.saveAll(singleChoiceAnswerables);

            var singleChoiceSentence = new RCSentence();
            singleChoiceSentence.setAssignables(singleChoiceAnswerables);
            List<Todo> singleChoiceSentences = new ArrayList<>();
            singleChoiceSentences.add(singleChoiceSentence);
            singleChoiceSentenceRepository.saveAll(singleChoiceSentences);

            var ex = new Exercise();
            ex.setTitle("Welcome");
            ex.setTodos(singleChoiceSentences);

            exerciseRepository.save(ex);

            var sue = new Teacher();
            sue.setProfileName("Sue");
            sue.setExercises(List.of(ex));
            teacherRepository.save(sue);

        };
    }
}
