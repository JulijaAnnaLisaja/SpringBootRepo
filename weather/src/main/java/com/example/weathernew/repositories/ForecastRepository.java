package com.example.weathernew.repositories;

import com.example.weathernew.models.forecast.ForecastTimeMainModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForecastRepository extends JpaRepository<ForecastTimeMainModel, Integer> {
}