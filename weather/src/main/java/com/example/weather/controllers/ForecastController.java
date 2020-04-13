package com.example.weather.controllers;

import com.example.weather.models.ForecastModel;
import com.example.weather.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Get and Post requests from forecast
 *
 *
 */
@RestController
public class ForecastController {
    static String apiKey = "f42afabb07138b319e71a4d8d6a08809";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    @Autowired
    private ForecastService service;

    /**
     * Allows to get forecast data from country and city
     *
     * @param city the city name, that allows to get weather data
     * @param country the country, that allows to get weather data
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/forecast/{country}/{city}")
    public @ResponseBody
    Object getForecastByCity(@PathVariable String city, @PathVariable String country) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country + "&APPID="+ apiKey,
                        Object.class);
        return response;
    }

    /**
     * Post new forecast record into
     *
     * @param forecast post entity
     * @return ResponseEntity.created(location).build()
     */
    @RequestMapping(method = RequestMethod.POST, value = "/forecast/{country}/{city}")
    public ResponseEntity<Object> createForecast(@Valid @RequestBody ForecastModel forecast) {
        ForecastModel savedForecast = service.save(forecast);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{country}/{city}")
                .buildAndExpand(savedForecast.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
