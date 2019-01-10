package cho.me.webclient;

import cho.me.webclient.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class WebclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebclientApplication.class, args);
	}

	@Autowired
	WebClient.Builder webClientBuilder;

	@Bean
	public ApplicationRunner applicationRunner(){
		return args -> {
				WebClient webClient = webClientBuilder.baseUrl("http://localhost:8080").build();

				Flux<User> users = webClient.get().uri("/users")
					.retrieve()
					.bodyToFlux(User.class);

				users.subscribe(WebclientApplication::handleResponse);


		};
	}

	private static void handleResponse(User users) {
		System.out.println("handle response");
		System.out.println(users);
	}
}

