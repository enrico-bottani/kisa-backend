package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;
import kisa.team.exercisesservice.dto.rc.TodoDTO;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class TodoToDTOMapper {
    public static TodoDTO map(Todo e) {
        if (e.getType().equals(TodoType.RC_SENTENCE_TYPE.toString())) {
            var rcSentence = (RCSentence) e;
            var assignables = rcSentence.getAssignables().stream().map(AssignableMapper::map).collect(Collectors.toList());
            var answerSheet = rcSentence.getAnswerSheet().stream().map(AnswerSheetToDTOMapper::map).collect(Collectors.toList());
            return new RCSentenceDTO(rcSentence.getType(), rcSentence.getPosition(),rcSentence.getId(), assignables, answerSheet);
        }

        return TodoDTO.builder().type(e.getType()).position(e.getPosition()).id(e.getId()).build();
    }
}
