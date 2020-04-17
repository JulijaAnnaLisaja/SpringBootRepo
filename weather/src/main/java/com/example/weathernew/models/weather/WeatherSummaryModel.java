package com.example.weathernew.models.weather;

import com.example.weathernew.models.weather.WeatherModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherSummaryModel {
    private String country;
    private String city;
    private Integer code;
    private String icon;
    private double temperature;

    public WeatherSummaryModel(String country, String city, WeatherModel weather) {
        this.country = country;
        this.city = city;
        this.code = weather.getWeatherId();
        this.icon = weather.getWeatherIcon();
        this.temperature = weather.getTemperature();
    }
}
