package com.interviewdot.WeatherApp.controller;

import com.interviewdot.WeatherApp.models.forecast.ForecastTimeMainModel;
import com.interviewdot.WeatherApp.repostories.ForecastRepository;
import com.interviewdot.WeatherApp.services.ForecastService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("weather")
public class ForecastController {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private ForecastRepository forecastRepository;

    /**
     * Output Information about the all-week forecast
     *
     * @param city the information about the city
     * @return city the name of the city
     */
    @ApiOperation("Return a JSON object that gives the weather averages.")
    @GetMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> weatherForecastAverage(@ApiParam("City's name") @RequestParam(required = true) String city) {
        return forecastService.forecastTemperatureAverage(city);
    }

    @ApiOperation("Return a JSON object that gives the weather averages.")
    @PostMapping(value = "/forecast", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> weatherForecastAverage(@Valid @RequestBody ForecastTimeMainModel main) {
        ForecastTimeMainModel weatherOptional = forecastRepository.save(main);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(weatherOptional.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
