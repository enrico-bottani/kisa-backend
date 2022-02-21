package kisa.team.exercisesservice.model.assignable.constant;

import kisa.team.exercisesservice.model.assignable.Assignable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ASSIGN_STRING_CONSTANT")
public class StringConstant extends Assignable {
    @Id
    Long id;
    String value;
    private String type="String";
}
