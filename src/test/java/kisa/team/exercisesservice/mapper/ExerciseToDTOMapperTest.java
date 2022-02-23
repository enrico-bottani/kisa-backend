package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.model.rc.Exercise;
import kisa.team.exercisesservice.model.todo.TodoTests;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExerciseToDTOMapperTest {
    public static class MOCKS{
        public static final Exercise EXERCISE = Exercise.builder()
                .id(23L).title("FooBar").selected(1).todos(Lists.list(TodoTests.MOCKS.RC_SENTENCE_TODO)).build();
    }
    @Test
    public void testExerciseMapSameId(){
        Assertions.assertEquals(23L,ExerciseToDTOMapper.map(MOCKS.EXERCISE).getId());
    }
}
