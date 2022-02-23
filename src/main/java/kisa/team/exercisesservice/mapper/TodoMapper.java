package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;
import kisa.team.exercisesservice.dto.rc.TodoDTO;
import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.todo.AnswerSheetItem;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TodoMapper {
    public static TodoDTO map(Todo e) {
        if (e.getType().equals(TodoType.RC_SENTENCE_TYPE.toString())) {
            var rcSentence = (RCSentence) e;
            var assignables = rcSentence.getAssignables().stream().map(AssignableMapper::map).collect(Collectors.toList());
            var answerSheet = rcSentence.getAnswerSheet().stream().map(AnswerSheetToDTOMapper::map).collect(Collectors.toList());
            return new RCSentenceDTO(rcSentence.getType(), rcSentence.getPosition(),rcSentence.getId(), assignables, answerSheet);
        }

        return TodoDTO.builder().type(e.getType()).position(e.getPosition()).id(e.getId()).build();
    }
    public static Todo map(TodoDTO e) {
        if (e.getType().equals(TodoType.RC_SENTENCE_TYPE.toString())) {
            var rcSentence = (RCSentenceDTO) e;
            List<Assignable> assignables = rcSentence.getAssignables().stream().map(AssignableMapper::map).collect(Collectors.toList());
            //List<AnswerSheetItem> answerSheet = rcSentence.getAnswerSheet().stream().map(AnswerSheetToDTOMapper::map).collect(Collectors.toList());
            List<AnswerSheetItem> answerSheet = new ArrayList<>();
            return new RCSentence(rcSentence.getId(),rcSentence.getPosition(), assignables, answerSheet);
        }

        return Todo.builder().position(e.getPosition()).id(e.getId()).build();
    }
}
