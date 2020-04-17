package com.example.weathernew.controllers.get;

import com.example.weathernew.models.location.LocationModel;
import com.example.weathernew.models.weather.WeatherModel;
import com.example.weathernew.services.LocationService;
import com.example.weathernew.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("location")
public class LocationGetController {
    @Autowired
    private final LocationService locationService;

    public LocationGetController(LocationService locationService) {
        this.locationService = locationService;
    }

    @ApiOperation("Return a JSON object that gives the weather averages.")
    @RequestMapping(method = RequestMethod.GET, value = "/get/{lat}/{lon}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    LocationModel getLocation(@PathVariable String lat,
                              @PathVariable String lon) {
        return this.locationService.getLocation(lat, lon);
    }
}
