package com.interviewdot.WeatherApp.repostories;


import com.interviewdot.WeatherApp.models.location.LocationMainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationMainModel, Integer> {

}
