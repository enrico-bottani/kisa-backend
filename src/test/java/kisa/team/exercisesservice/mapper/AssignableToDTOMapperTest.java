package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.model.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.todo.RCSentence;
import kisa.team.exercisesservice.model.todo.Todo;
import kisa.team.exercisesservice.model.todo.TodoType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssignableToDTOMapperTest {
    private static final int POSITION = 12;
    private static final int ID = 23;
    private static final Todo TODO = new Todo(ID,POSITION,TodoType.TODO.toString());

    @Test
    public void testTODOPosition(){
        var todoDTO = TodoToDTOMapper.map(TODO);
        Assertions.assertEquals(todoDTO.getPosition(), POSITION);
    }
    @Test
    public void testTODOType(){
        var todoDTO = TodoToDTOMapper.map(TODO);
        Assertions.assertEquals(todoDTO.getType(), TodoType.TODO.toString());
    }
    @Test
    public void testTODOID(){
        var todoDTO = TodoToDTOMapper.map(TODO);
        Assertions.assertEquals(todoDTO.getId(), ID);
    }

}
