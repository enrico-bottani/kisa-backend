package kisa.team.exercisesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerSheetItemDTO {
    int givenAnswerID;
    int correctAnswerID;
    int status;
}
