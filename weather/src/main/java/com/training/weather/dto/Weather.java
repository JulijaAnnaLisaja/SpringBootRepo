package com.training.weather.dto;

import com.training.weather.model.WeatherEntry;


public class Weather extends WeatherEntry {

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
