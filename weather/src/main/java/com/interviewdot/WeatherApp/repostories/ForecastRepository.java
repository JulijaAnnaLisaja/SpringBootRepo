package com.interviewdot.WeatherApp.repostories;

import com.interviewdot.WeatherApp.models.forecast.ForecastTimeMainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<ForecastTimeMainModel, Integer> {

}
