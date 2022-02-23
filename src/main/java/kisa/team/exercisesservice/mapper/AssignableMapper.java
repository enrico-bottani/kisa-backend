package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.RCAnswerableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;
import kisa.team.exercisesservice.model.assignable.Assignable;
import kisa.team.exercisesservice.model.assignable.AssignableType;
import kisa.team.exercisesservice.model.assignable.answerable.RCAnswerable;
import kisa.team.exercisesservice.model.assignable.answerable.RCAnswerableItem;
import kisa.team.exercisesservice.model.assignable.constant.StringConstant;

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
}
