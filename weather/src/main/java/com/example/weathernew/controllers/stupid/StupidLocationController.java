package com.example.weathernew.controllers.stupid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

public class StupidLocationController {
    static String key = "f42afabb07138b319e71a4d8d6a08809";
    static RestTemplate restTemplate = new RestTemplate();
    /**
     * Allows to get OpenWeather data from latitude and longitude
     *
     * @param lat the city name, that allows to get weather data
     * @param lon the country, that allows to get weather data
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/location/{lat}/{lon}")
    public @ResponseBody
    Object getWeatherByCountryCity(@PathVariable String lat, @PathVariable String lon) {

        ResponseEntity<Object> response = restTemplate.
                getForEntity("http://api.openweathermap.org/data/2.5/weather?q=" + lat + "," + lon + "&APPID="+ key,
                        Object.class);
        return response;
    }
}
