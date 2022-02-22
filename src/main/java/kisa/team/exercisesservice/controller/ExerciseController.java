package kisa.team.exercisesservice.controller;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;
import kisa.team.exercisesservice.parser.RCParser;
import kisa.team.exercisesservice.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
public class ExerciseController {
    ExerciseService exerciseService;

    @Autowired
    public void getExerciseService(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }


    @GetMapping(value = "/exercises")
    public ResponseEntity<List<ExerciseDto>> getByTitle(@RequestParam(name = "title",defaultValue = "") String title){
        return ResponseEntity.ok(exerciseService.getExercisesDtoByTitleContains(title));
    }
    @GetMapping(value = "/exercise/{id}")
    public ResponseEntity<ExerciseDto> getById(@PathVariable(name = "id") long id) throws IOException {
        return ResponseEntity.ok(RCParser.parseFromJSON("static/dto/rc_ex2_sample.json"));
    }
    @PostMapping(value = "/exercise/{id}/rc.json")
    public ResponseEntity<ExerciseDto> setRCSentence(@PathVariable(name = "id") long id, @RequestBody RCSentenceDTO rcSentenceDTO){
        Optional<ExerciseDto> e = exerciseService.setSentence(id,rcSentenceDTO);
        return e.map(exerciseDto -> ResponseEntity.status(201).body(exerciseDto))
                .orElseGet(() -> ResponseEntity.of(e));
    }
}
