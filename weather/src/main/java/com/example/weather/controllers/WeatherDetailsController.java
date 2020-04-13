package com.example.weather.controllers;

import com.example.weather.models.WeatherDetailsModel;
import com.example.weather.service.WeatherDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherDetailsController {

    @Autowired
    WeatherDetailsService weatherDetailsService;
    @Autowired
    private Environment env;

    @RequestMapping(method = RequestMethod.POST, value = "/WeatherDetails/{country}/{city}")
    public @ResponseBody
    WeatherDetailsModel saveWeatherDetails(@PathVariable String country, @PathVariable String city) {

        final String uri = "http://localhost:8080/forecast/" + country + "/" + city;

        RestTemplate restTemplate = new RestTemplate();
        Object result = restTemplate.getForObject(uri, Object.class);
        WeatherDetailsModel wd = new WeatherDetailsModel(result.toString().substring(1, 239)+" "+env.getProperty("username"));
        WeatherDetailsModel wd2 = weatherDetailsService.saveWeather(wd);
        return wd2;

    }

}
