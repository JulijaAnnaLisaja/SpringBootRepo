package com.example.weathernew;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * Class that is necesary for the API konnection
 *
 */
@ConfigurationProperties("app.weather")
public class WeatherApiProperties {

    @Valid
    private final Api api = new Api();

    private List<String> locations = Arrays.asList("UK/London", "Russia/Moscow");


    public Api getApi() {
        return this.api;
    }

    public List<String> getLocations() {
        return this.locations;
    }

    /**
     * Static class, that uses Api key for connection
     *
     */
    public static class Api {

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
