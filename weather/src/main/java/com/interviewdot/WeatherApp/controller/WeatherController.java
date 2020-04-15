package com.interviewdot.WeatherApp.controller;

import com.interviewdot.WeatherApp.repostories.WeatherRepository;
import com.interviewdot.WeatherApp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;

public class WeatherController {

    @Autowired
    private WeatherService weatherServiceService;

    @Autowired
    private WeatherRepository weatherRepository;
}
