package kisa.team.exercisesservice.parser;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import kisa.team.exercisesservice.dto.rc.assignables.AssignableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.RCAnswerableDTO;
import kisa.team.exercisesservice.dto.rc.assignables.StringConstantDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignableDTOSerializer extends StdDeserializer<AssignableDTO> {
    public AssignableDTOSerializer() {
        this(null);
    }

    public AssignableDTOSerializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AssignableDTO deserialize(JsonParser parser, DeserializationContext deserializer) throws IOException, JacksonException {
        ObjectCodec codec = parser.getCodec();
        JsonNode node = null;
        node = codec.readTree(parser);
        var type = node.get("type").asText();
        if (type.equals("STR")) {
            return new StringConstantDTO( node.get("value").asText());
        } else if (type.equals("RCA")) {
            List<String> choices = new ArrayList<>();
            var choicesIterator = node.get("choices").elements();
            while (choicesIterator.hasNext()) {
                choices.add(choicesIterator.next().asText());
            }
            return new RCAnswerableDTO((choices).toArray(new String[choices.size()]));
        }

        return new AssignableDTO();
    }
}
