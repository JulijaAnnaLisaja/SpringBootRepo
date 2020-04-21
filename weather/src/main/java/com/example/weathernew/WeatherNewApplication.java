package com.example.weathernew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableConfigurationProperties(WeatherApiProperties.class)
@EnableCaching(proxyTargetClass = true)
public class WeatherNewApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherNewApplication.class, args);
	}

}
