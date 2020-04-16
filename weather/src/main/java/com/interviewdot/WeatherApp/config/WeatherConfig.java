package com.interviewdot.WeatherApp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ConfigurationProperties("app.weather")
public class WeatherConfig {

    @Valid
    private final Api api = new Api();

    public Api getApi() {
        return this.api;
    }

    public static class Api {

        /**
         * API key of the OpenWeather service
         */
        @NotNull
        private String key;

        public String getKey() {
            return this.key;
        }

        public void setKey(String key) {
            this.key = key;
        }

    }

}
