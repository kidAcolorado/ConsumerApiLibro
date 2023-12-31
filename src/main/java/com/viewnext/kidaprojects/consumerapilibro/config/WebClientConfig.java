package com.viewnext.kidaprojects.consumerapilibro.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

	private static final String BASE_URL = "http://localhost:8080";
	
	@Bean
	WebClient libroWebClient() {
		String apiUrl = BASE_URL;
		return WebClient.create(apiUrl);
	}
	
}
