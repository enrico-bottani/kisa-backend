package kisa.team.exercisesservice.service;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.mapper.ExerciseMapper;
import kisa.team.exercisesservice.repository.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    ExerciseRepository exerciseRepository;
    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
    }
    public List<ExerciseDto> getExercisesDtoByTitleContains(String title){
       return exerciseRepository.getExercisesByTitleContains(title).stream()
               .map(ExerciseMapper::map)
               .collect(Collectors.toList());
    }

    public Optional<ExerciseDto> getExerciseById(long id){
       return this.exerciseRepository
               .getExerciseById(id)
               .map(ExerciseMapper::map);
    }


    public Optional<ExerciseDto> addExercise(ExerciseDto exerciseDto) {

        this.exerciseRepository.save(ExerciseMapper.map(exerciseDto));
        return Optional.of(exerciseDto);
    }
}
