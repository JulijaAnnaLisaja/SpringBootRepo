package com.training.weather;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@SpringBootApplication
@ComponentScan({"com.training.weather.model"})
@ComponentScan({"com.training.weather.controller"})
@EnableJpaRepositories({"com.training.weather.repository"})
@EnableAutoConfiguration
//@EnableSwagger // auto generation of API docs
@EnableWebMvc
@EnableAspectJAutoProxy
@EnableConfigurationProperties
public class WeatherApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

}
