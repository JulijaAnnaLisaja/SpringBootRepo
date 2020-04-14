package com.interviewdot.WeatherApp.repostories;

import com.interviewdot.WeatherApp.models.WeatherTimeMainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<WeatherTimeMainModel, Integer> {

}
