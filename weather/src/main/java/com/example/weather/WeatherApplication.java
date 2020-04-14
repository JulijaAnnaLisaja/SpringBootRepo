package com.example.weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Application main class
 *
 */
@SpringBootApplication
public class WeatherApplication {
	// The first step of rest template

	/**
	 * RestTrmplate methot that connect application to API
	 *
	 * @return new RestTemplate
	 */
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	/**
	 * Main method of the application
	 *
	 * @param args contain all main features of the application
	 */
	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

}
