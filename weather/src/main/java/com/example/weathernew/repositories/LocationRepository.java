package com.example.weathernew.repositories;

import com.example.weathernew.models.location.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationModel, Integer> {
}
