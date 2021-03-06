package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;
import kisa.team.exercisesservice.model.rc.assignable.AssignableTests;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TodoMapperTest {
    Todo todo = new Todo();
    Todo todoId1Pos41 = new Todo(1, 41);

    RCSentence EMPTY_RC_SENTENCE = new RCSentence(1, 41, new ArrayList<>(), new ArrayList<>());

    RCSentence TWO_ASSIGN_RC_SENTENCE = new RCSentence(1, 41,
            Lists.list(AssignableTests.MOCKS.MOCK_STRING_CONSTANT_HELLO_WORLD, AssignableTests.MOCKS.MOCK_STRING_CONSTANT_HELLO_WORLD), new ArrayList<>());


    @Test
    public void genericTodoGetType() throws IOException {
        assertEquals(TodoType.TODO.toString(), TodoMapper.map(todo).getType());
    }

    @Test
    public void genericTodoGetId() throws IOException {
        assertEquals(1, TodoMapper.map(todoId1Pos41).getId());
    }

    @Test
    public void genericTodoGetPosition() throws IOException {
        assertEquals(41, TodoMapper.map(todoId1Pos41).getPosition());
    }

    @Test
    public void emptyRCSentenceGetType() throws IOException {
        assertEquals(TodoType.RC_SENTENCE_TYPE.toString(), TodoMapper.map(EMPTY_RC_SENTENCE).getType());
    }

    @Test
    public void emptyRCSentenceGetAnswerSheet() throws IOException {
        assertEquals(0, ((RCSentenceDTO) TodoMapper.map(EMPTY_RC_SENTENCE)).getAnswerSheet().size());
    }

    @Test
    public void twoAssignRCSentenceGetAssignablesNumber() throws IOException {
        assertEquals(2, ((RCSentenceDTO) TodoMapper.map(TWO_ASSIGN_RC_SENTENCE)).getAssignables().size());
    }

    @Test
    public void twoAssignRCSentenceGetStringAssignable1() throws IOException {
        assertEquals(AssignableTests.MOCKS.MOCK_STRING_HELLO_WORLD, ((StringConstantDTO) ((RCSentenceDTO) TodoMapper
                .map(TWO_ASSIGN_RC_SENTENCE)).getAssignables().get(0)).getValue());
    }


}
