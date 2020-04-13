package com.example.weather.models;

import javax.persistence.*;

@Entity
public class WeatherDetailsModel {
    public WeatherDetailsModel(Long id, String details) {
        this.id = id;
        this.details = details;
    }

    public WeatherDetailsModel(String details) {
        this.details = details;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
   Long id;
    String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
