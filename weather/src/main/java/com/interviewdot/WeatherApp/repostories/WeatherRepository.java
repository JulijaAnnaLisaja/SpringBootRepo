package com.interviewdot.WeatherApp.repostories;

import com.interviewdot.WeatherApp.models.weather.WeatherMainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherMainModel, Integer> {

}
