package com.example.weather.repository;

import com.example.weather.models.WeatherDetailsModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface WeatherDetailsRepository extends CrudRepository<WeatherDetailsModel, Long> {
    public WeatherDetailsModel save(WeatherDetailsModel weatherDetailsModel);
}


