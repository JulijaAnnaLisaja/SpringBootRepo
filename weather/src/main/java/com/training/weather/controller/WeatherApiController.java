package com.training.weather.controller;

import com.training.weather.dto.Weather;
import com.training.weather.model.WeatherDetails;
import com.training.weather.repository.WeatherForecast;
import com.training.weather.service.WeatherDetailsService;
import com.training.weather.service.WeatherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/weather")
public class WeatherApiController {

    @Autowired
    private final WeatherService weatherService;
    private final WeatherDetailsService weatherDetailsService;

    public WeatherApiController(WeatherService weatherService, WeatherDetailsService weatherDetailsService) {
        this.weatherService = weatherService;
        this.weatherDetailsService = weatherDetailsService;
    }


    @RequestMapping(value = "/now/{country}/{city}", method = RequestMethod.GET)
    @ResponseBody
    public Weather getWeather(@PathVariable String country,
                              @PathVariable String city) {
        return this.weatherService.getWeather(country, city);
    }

    @RequestMapping("/weekly/{country}/{city}")
    public WeatherForecast getWeatherForecast(@PathVariable String country,
                                              @PathVariable String city) {
        return this.weatherService.getWeatherForecast(country, city);
    }

    //TODO add methods, which shows, saves (?) the data in db.
}
