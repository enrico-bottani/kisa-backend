package kisa.team.exercisesservice.model.rc.assignable.answerable;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RCAnswerableTests {
    public static class MOCKS {
        public static String[] answerableChoices = new String[]{"on", "at"};
        public static RCAnswerable RC_ANSWERABLE = new RCAnswerable(1L, IntStream.range(0, answerableChoices.length)
                .mapToObj(i -> new RCAnswerableItem(i, answerableChoices[i])).collect(Collectors.toList()));
    }

    @Test
    public void choice1IsPresentTest() {
        assertEquals("on", MOCKS.RC_ANSWERABLE.getChoices().get(0).value);
    }

    @Test
    public void choice2IsPresentTest() {
        assertEquals("at", MOCKS.RC_ANSWERABLE.getChoices().get(1).value);
    }

    @Test
    public void choicesSizeTest() {
        assertEquals(2, MOCKS.RC_ANSWERABLE.getChoices().size());
    }

}
