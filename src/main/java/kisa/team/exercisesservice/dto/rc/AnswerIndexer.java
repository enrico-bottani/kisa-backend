package kisa.team.exercisesservice.dto.rc;

import lombok.Data;

@Data
public class AnswerIndexer {
    private int index;
    public AnswerIndexer(){
        this.index = 0;
    }
    public AnswerIndexer(int index){
         this.index = index;
    }
}
