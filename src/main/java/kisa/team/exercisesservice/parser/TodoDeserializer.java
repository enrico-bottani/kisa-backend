package kisa.team.exercisesservice.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kisa.team.exercisesservice.dto.AnswerSheetItemDTO;
import kisa.team.exercisesservice.dto.rc.AnswerIndexerDTO;
import kisa.team.exercisesservice.dto.rc.TodoDTO;
import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;

import java.io.IOException;
import java.util.Arrays;

public class TodoDeserializer extends StdDeserializer<TodoDTO> {
    public TodoDeserializer() {
        this(null);
    }

    public TodoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public TodoDTO deserialize(JsonParser parser, DeserializationContext deserializer) {
        TodoDTO car = new TodoDTO();
        ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        try {
            node = codec.readTree(parser);
            var position = node.get("position").asInt();
            var type = node.get("type").asText();
            car.setPosition(position);
            car.setType(type);
            if (type.equals("RCT")) {
                RCSentenceDTO rcSentence = new RCSentenceDTO();
                rcSentence.setPosition(position);
                rcSentence.setType(type);
                var mapper = new ObjectMapper();
                SimpleModule module =
                        new SimpleModule("CustomCarDeserializer", new Version(1, 0, 0, null, null, null));

                module.addDeserializer(AssignableDTO.class, new AssignableDTOSerializer());
                mapper.registerModule(module);
                rcSentence.setAssignables(Arrays.asList(
                        mapper.treeToValue(
                                node.get("assignables"), AssignableDTO[].class)));
                rcSentence.setAnswerMap(Arrays.asList(
                        mapper.treeToValue(
                                node.get("answerMap"), AnswerIndexerDTO[].class)));
                rcSentence.setAnswerSheet(Arrays.asList(
                        mapper.treeToValue(
                                node.get("answerSheet"), AnswerSheetItemDTO[].class)));
                return rcSentence;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return car;
    }
}
