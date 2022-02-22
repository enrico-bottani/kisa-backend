package kisa.team.exercisesservice.parser;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.dto.rc.TodoDTO;
import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;

import java.io.IOException;
import java.net.URL;

public class RCParser {
    public static ExerciseDto parseFromJSON(String path) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        SimpleModule module =
                new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));
        module.addDeserializer(TodoDTO.class, new TodoDeserializer());
        module.addDeserializer(AssignableDTO.class, new AssignableDTOSerializer());
        mapper.registerModule(module);

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL is = classloader.getResource(path);
        return mapper.readValue(is, ExerciseDto.class);
    }
}
