package kisa.team.exercisesservice.service;

import kisa.team.exercisesservice.dto.ExerciseDto;
import kisa.team.exercisesservice.parser.RCParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class ExerciseServiceTests {

    /* TEST API Sospesi fino a quando non si capisce bene come vadano fatti...
    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    @Autowired
    Environment environment;

    @Test
    public void getExercises_NotBlankResponse_Test()
            throws IOException, InterruptedException {
        String port = environment.getProperty("local.server.port");
        System.out.println("\n\nACTIVE/DEFAULT ENV");
        Arrays.stream(environment.getActiveProfiles()).forEach(e->System.out.print(e+" "));
        System.out.println();
        Arrays.stream(environment.getDefaultProfiles()).forEach(e->System.out.print(e+" "));


        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:" + port + "/exercises"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
        assertFalse(response.isBlank());
        System.out.println(response);
    }

    @Test
    public void getExercises_ResponseIs_Test()
            throws IOException, InterruptedException {
        String port = environment.getProperty("local.server.port");
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:" + port + "/exercise/4"))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();
        try {
            var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
            ExerciseDto e = RCParser.parseFromJSON(response);
            System.out.println(e);
        } catch (ConnectException exception) {
            exception.printStackTrace();
        }
    }
*/
}
