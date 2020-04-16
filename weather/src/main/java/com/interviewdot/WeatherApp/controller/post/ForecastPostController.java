package com.interviewdot.WeatherApp.controller.post;

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
public class ForecastPostController {

    @Autowired
    private ForecastService forecastService;

    @Autowired
    private ForecastRepository forecastRepository;

    /**
     * Write new data into ForecastTimeMainModel class
     *
     * @param main all ForecastTimeMainModel class data
     * @return created entity
     */
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
