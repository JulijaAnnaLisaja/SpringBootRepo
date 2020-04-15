package com.interviewdot.WeatherApp.controller;


import com.interviewdot.WeatherApp.repostories.LocationRepository;
import com.interviewdot.WeatherApp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;

public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationRepository locationRepository;

}
