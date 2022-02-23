package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.RCAnswerableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;
import kisa.team.exercisesservice.model.rc.assignable.Assignable;
import kisa.team.exercisesservice.model.rc.assignable.AssignableType;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.rc.assignable.answerable.RCAnswerableItem;
import kisa.team.exercisesservice.model.rc.assignable.constant.StringConstant;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AssignableMapper {
    public static AssignableDTO map(Assignable assignable) {
        if (assignable.getType().equals(AssignableType.RC_ANSWERABLE.toString())) {
            RCAnswerable rc = (RCAnswerable) assignable;
            return new RCAnswerableDTO(rc.getChoices().stream().map(RCAnswerableItem::getValue)
                            .toArray(String[]::new));
        } else if (assignable.getType().equals(AssignableType.STRING.toString())){
            StringConstant st = (StringConstant) assignable;
            return new StringConstantDTO(st.getValue());
        }
        else {
            return new AssignableDTO();
        }
    }
    public static Assignable map(AssignableDTO assignable) {
        if (assignable.getType().equals(AssignableType.RC_ANSWERABLE.toString())) {
            RCAnswerableDTO rc = (RCAnswerableDTO) assignable;
            return new RCAnswerable(1,(Arrays.stream(rc.getChoices()).map(c->new RCAnswerableItem(0,c)).collect(Collectors.toList())));
        } else if (assignable.getType().equals(AssignableType.STRING.toString())){
            StringConstantDTO st = (StringConstantDTO) assignable;
            return new StringConstant(st.getValue());
        }
        else {
            return new Assignable();
        }
    }
}
