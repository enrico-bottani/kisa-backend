package kisa.team.exercisesservice.model.todo;

import kisa.team.exercisesservice.model.rc.assignable.AssignableTests;
import org.assertj.core.util.Lists;

import java.util.ArrayList;

public class TodoTests {
    public static class MOCKS {
        public static final Todo RC_SENTENCE_TODO = new RCSentence(123L, 0,
                Lists.list(AssignableTests.MOCKS.MOCK_STRING_CONSTANT_HELLO_WORLD,
                        AssignableTests.MOCKS.MOCK_RC_ANSWERABLE_ON_OFF), new ArrayList<>());
    }

}
