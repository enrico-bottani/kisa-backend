package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.assignables.RCAnswerableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;
import kisa.team.exercisesservice.model.assignable.Assignable;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import kisa.team.exercisesservice.model.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.assignable.answerable.SingleChoiceSentenceChoice;
import kisa.team.exercisesservice.model.assignable.constant.StringConstant;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import kisa.team.exercisesservice.parser.RCParser;
import kisa.team.exercisesservice.parser.RCParserTest;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignableToDTOMapperTest {
    private static final long ID = 12;
    private static final String STRING_VALUE = "2'0odaSOD)";
    private static final SingleChoiceSentenceChoice[] choices = {
            new SingleChoiceSentenceChoice(0, "test"),new SingleChoiceSentenceChoice(1, "test2")};


    private static final Assignable ASSIGNABLE = new Assignable(ID);
    private static final Assignable STRING_ASSIGN = new StringConstant(ID, STRING_VALUE);
    private static final Assignable RC_ASSIGN = new RCAnswerable(ID, Arrays.asList(choices));

    @Test
    public void genericAssignableGetType() throws IOException {
        var e = AssignableToDTOMapper.map(ASSIGNABLE);
        assertEquals(AssignableType.Undefined.toString(), e.getType());
    }

    @Test
    public void stringAssignableGetType() throws IOException {
        var e = AssignableToDTOMapper.map(STRING_ASSIGN);
        assertEquals(AssignableType.STRING.toString(), e.getType());
    }

    @Test
    public void stringAssignableGetStringValue() throws IOException {
        var e = AssignableToDTOMapper.map(STRING_ASSIGN);
        assertEquals(STRING_VALUE, ((StringConstantDTO) e).getValue());
    }

    @Test
    public void rcAssignableGetType() throws IOException {
        var e = AssignableToDTOMapper.map(RC_ASSIGN);
        assertEquals(AssignableType.RC_ANSWERABLE.toString(), ((RCAnswerableDTO) e).getType());
    }

    @Test
    public void rcAssignableGetChoices() throws IOException {
        var e = AssignableToDTOMapper.map(RC_ASSIGN);
        var actual = Arrays.stream(choices).map(SingleChoiceSentenceChoice::getValue)
                .toArray(String[]::new);
        assertTrue(Arrays.equals(((RCAnswerableDTO) e).getChoices(), actual));
    }
}
