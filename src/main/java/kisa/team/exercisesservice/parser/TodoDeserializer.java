package kisa.team.exercisesservice.parser;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import kisa.team.exercisesservice.dto.TodoDTO;
import kisa.team.exercisesservice.dto.rc.AssignableDTO;
import kisa.team.exercisesservice.dto.rc.RCSentenceDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
                rcSentence.setAssignables(Arrays.asList(
                        mapper.treeToValue(
                                node.get("assignables"), AssignableDTO[].class)));
                return rcSentence;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return car;
    }
}
