package com.example.weathernew.controllers.get;

import com.example.weathernew.models.weather.WeatherModel;
import com.example.weathernew.models.forecast.ForecastModel;
import com.example.weathernew.services.WeatherService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("weather")
public class WeatherGetController {

    @Autowired
    private final WeatherService weatherService;

    public WeatherGetController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @ApiOperation("Return a JSON object that gives the weather averages.")
    @RequestMapping(method = RequestMethod.GET, value = "/now/{country}/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody WeatherModel getWeather(@PathVariable String country,
                                   @PathVariable String city) {
        return this.weatherService.getWeather(country, city);
    }

    @ApiOperation("Return a JSON object that gives the weather averages.")
    @RequestMapping(method = RequestMethod.GET, value = "/weekly/{country}/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ForecastModel getWeatherForecast(@PathVariable String country,
                                            @PathVariable String city) {
        return this.weatherService.getWeatherForecast(country, city);
    }
}