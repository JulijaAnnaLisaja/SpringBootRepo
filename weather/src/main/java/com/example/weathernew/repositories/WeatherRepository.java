package com.example.weathernew.repositories;

import com.example.weathernew.models.weather.WeatherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherModel, Integer> {
}