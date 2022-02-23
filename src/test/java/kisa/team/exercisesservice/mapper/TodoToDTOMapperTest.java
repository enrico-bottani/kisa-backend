package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.model.assignable.AssignableType;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoToDTOMapperTest {
    Todo todo = new Todo();
    Todo todoId1Pos41 = new Todo(1,41);
    @Test
    public void genericTodoGetType() throws IOException {
        assertEquals(TodoType.TODO.toString(), todo.getType());
    }
    @Test
    public void genericTodoGetId() throws IOException {
        assertEquals(1, todoId1Pos41.getId());
    }
    @Test
    public void genericTodoGetPosition() throws IOException {
        assertEquals(41, todoId1Pos41.getPosition());
    }
}
