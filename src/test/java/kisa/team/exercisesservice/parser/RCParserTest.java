package kisa.team.exercisesservice.parser;

import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RCParserTest {
    @Test
    public void getExercises_NotBlankResponse_Test() throws IOException {
        var e = RCParser.parseFromFile("static/dto/rc_ex_sample.json");
        System.out.println(e);
    }
    @Test
    public void getExercises_NotBlankResponse2_Test() throws IOException {
        var e = RCParser.parseFromFile("static/dto/rc_ex2_sample.json");
        System.out.println(e);
    }
}
