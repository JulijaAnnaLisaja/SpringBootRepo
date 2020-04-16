package com.interviewdot.WeatherApp.controller.stupid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class StupidForecastController {
    static String apiKey = "f42afabb07138b319e71a4d8d6a08809";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    /**
     * Allows to get OpenWeather "/forecast" from country and city
     *
     * @param city the city name, that allows to get forecast data
     * @param country the country, that allows to get forecast data
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/forecast/{country}/{city}")
    public @ResponseBody
    Object getForecastByCountryCity(@PathVariable String city, @PathVariable String country) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "," + country + "&APPID="+ apiKey,
                        Object.class);
        return response;
    }

    /**
     * Allows to get OpenWeather "/forecast" only from country and city
     *
     * @param city the city name, that allows to get forecast data
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/forecast/{city}")
    public @ResponseBody
    Object getForecastByCity(@PathVariable String city) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&APPID="+ apiKey,
                        Object.class);
        return response;
    }
}
