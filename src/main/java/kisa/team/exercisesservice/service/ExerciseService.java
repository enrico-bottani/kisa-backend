package kisa.team.exercisesservice.service;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;
import kisa.team.exercisesservice.mapper.ExerciseToDTOMapper;
import kisa.team.exercisesservice.repository.exercise.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExerciseService {

    ExerciseToDTOMapper exerciseToDtoMapper;
    ExerciseRepository exerciseRepository;
    @Autowired
    ExerciseService(ExerciseToDTOMapper exerciseToDtoMapper, ExerciseRepository exerciseRepository){
        this.exerciseRepository = exerciseRepository;
        this.exerciseToDtoMapper = exerciseToDtoMapper;
    }

    public List<ExerciseDto> getExercisesDtoByTitleContains(String title){
       return exerciseRepository.getExercisesByTitleContains(title).stream()
               .map(exerciseToDtoMapper::map)
               .collect(Collectors.toList());
    }

    public Optional<ExerciseDto> getExerciseById(long id){
       return this.exerciseRepository
               .getExerciseById(id)
               .map(exerciseToDtoMapper::map);
    }

    public Optional<ExerciseDto> setSentence(long exerciseId, RCSentenceDTO rcSentenceDTO){
        System.out.println("DEB. Exercise created...");
        return Optional.of( ExerciseDto.builder().build());
    }
}
