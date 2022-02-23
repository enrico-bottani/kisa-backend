package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.assignables.RCAnswerableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;
import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.rc.assignable.AssignableType;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerableItem;
import kisa.team.exercisesservice.model.rc.assignable.constant.StringConstant;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AssignableMapperTest {
    private static final long ID = 12;

    private static final Assignable ASSIGNABLE = new Assignable(ID);

    private static final RCAnswerableItem[] choices = {
            new RCAnswerableItem(0, "answer1"),new RCAnswerableItem(1, "answer2")};
    public static final Assignable RC_ASSIGN = new RCAnswerable(ID, Arrays.asList(choices));

    public static final String STRING_VALUE = "2'0odaSOD)";
    public static final Assignable STRING_ASSIGN = new StringConstant(ID, STRING_VALUE);

    @Test
    public void genericAssignableGetType() throws IOException {
        var e = AssignableMapper.map(ASSIGNABLE);
        assertEquals(AssignableType.Undefined.toString(), e.getType());
    }

    @Test
    public void stringAssignableGetType() throws IOException {
        var e = AssignableMapper.map(STRING_ASSIGN);
        assertEquals(AssignableType.STRING.toString(), e.getType());
    }

    @Test
    public void stringAssignableGetStringValue() throws IOException {
        var e = AssignableMapper.map(STRING_ASSIGN);
        assertEquals(STRING_VALUE, ((StringConstantDTO) e).getValue());
    }

    @Test
    public void rcAssignableGetType() throws IOException {
        var e = AssignableMapper.map(RC_ASSIGN);
        assertEquals(AssignableType.RC_ANSWERABLE.toString(), ((RCAnswerableDTO) e).getType());
    }

    @Test
    public void rcAssignableGetChoices() throws IOException {
        var e = AssignableMapper.map(RC_ASSIGN);
        var actual = Arrays.stream(choices).map(RCAnswerableItem::getValue)
                .toArray(String[]::new);
        assertTrue(Arrays.equals(((RCAnswerableDTO) e).getChoices(), actual));
    }
}
