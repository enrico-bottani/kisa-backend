package kisa.team.exercisesservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class ExercisesServiceApplicationTests {
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
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create("http://localhost:"+port+"/exercises"))
				.setHeader("User-Agent", "Java 11 HttpClient Bot")
				.build();
		try {
			var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString()).body();
			assertFalse(response.isBlank());
		}catch (ConnectException exception){
			exception.printStackTrace();
		}
	}

}
