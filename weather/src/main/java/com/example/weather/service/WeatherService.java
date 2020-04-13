package com.example.weather.service;

import com.example.weather.models.WeatherModel;
import com.example.weather.repository.WeatherDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Weather component class
 *
 */
@Component
public class WeatherService {

    @Autowired
    WeatherDetailsRepository weatherDetailsRepository;

        private static List<WeatherModel> weather = new ArrayList<>();

        private static int usersCount = 3;

        static {
            weather.add(new WeatherModel(1, "", "", "", "" ));
            weather.add(new WeatherModel( 2, "", "", "", ""));
            weather.add(new WeatherModel( 3, "", "", "", ""));
        }

}
