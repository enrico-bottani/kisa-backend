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
public class ExerciseController {
    ExerciseService exerciseService;

    @Autowired
    public void getExerciseService(ExerciseService exerciseService){
        this.exerciseService = exerciseService;
    }

    @CrossOrigin
    @GetMapping(value = "/exercises.json")
    public ResponseEntity<List<ExerciseDto>> getByTitle(@RequestParam(name = "title",defaultValue = "") String title){
        return ResponseEntity.ok(exerciseService.getExercisesDtoByTitleContains(title));
    }
    @CrossOrigin
    @GetMapping(value = "/exercise/{id}.json")
    public ResponseEntity<ExerciseDto> getById(@PathVariable(name = "id") long id){
        return ResponseEntity.of(exerciseService.getExerciseById(id));
    }
    @PostMapping(value = "/exercise.json")
    public ResponseEntity<ExerciseDto> postExercise(@RequestBody String exerciseDto) throws IOException {
        Optional<ExerciseDto> e = exerciseService.addExercise(RCParser.parseFromJSON(exerciseDto));
        return ResponseEntity.of(e);
    }
}
