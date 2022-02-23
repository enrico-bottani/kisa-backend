package kisa.team.exercisesservice.mapper;

import kisa.team.exercisesservice.dto.AnswerSheetItemDTO;
import kisa.team.exercisesservice.model.todo.AnswerSheetItem;

public class AnswerSheetToDTOMapper {
    public static AnswerSheetItemDTO map(AnswerSheetItem a){
        return new AnswerSheetItemDTO(a.getGivenAnswerID(), a.getCorrectAnswerID(),a.getStatus());
    }
}
