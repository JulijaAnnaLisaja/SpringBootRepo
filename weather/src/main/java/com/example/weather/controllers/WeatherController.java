package com.example.weather.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Get and Post requests from forecast
 *
 * Post requests are in process
 */
@RestController
public class WeatherController {
    static String apiKey = "f42afabb07138b319e71a4d8d6a08809";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    /**
     * Method, that allows to search information about the weather by city
     *
     * @param city the city of the weather response
     * @param country the country of the weather response
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/byCity/{country}/{city}")
    public @ResponseBody Object getWeatherByCity(@PathVariable String city, @PathVariable String country) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country +
                                "&APPID="+ apiKey,
                        Object.class);
        return response;
    }

    /**
     * Allows to get information about the weather by coordinates
     *
     * @param lat Latitude of the location
     * @param lon Longitude of the location
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/coordinates/{lat}/{lon}")
    public @ResponseBody Object getWeather(@PathVariable String lat, @PathVariable String lon) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("https://api.openweathermap.org/data/2.5/onecall?lat=" + lat + "&lon=" + lon +
                                "&appid=" + apiKey,
                        Object.class);
        return response;
    }
}
