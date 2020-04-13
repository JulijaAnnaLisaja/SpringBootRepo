package com.example.weather.service;

import com.example.weather.models.WeatherDetailsModel;
import com.example.weather.repository.WeatherDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeatherDetailsService {
    @Autowired
    WeatherDetailsRepository weatherDetailsRepository;

    @Transactional
    public WeatherDetailsModel saveWeather(WeatherDetailsModel weather) {
       WeatherDetailsModel wd =  weatherDetailsRepository.save(weather);
       return wd;
    }

}
