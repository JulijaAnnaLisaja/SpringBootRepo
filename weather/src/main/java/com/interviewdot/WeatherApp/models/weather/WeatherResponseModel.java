package com.interviewdot.WeatherApp.models.weather;

import com.interviewdot.WeatherApp.models.location.LocationMainModel;

public class WeatherResponseModel {
    private WeatherMainModel weatherMainModel;

    public WeatherResponseModel() {
    }

    public WeatherResponseModel(WeatherMainModel weatherMainModel) {
        this.weatherMainModel = weatherMainModel;
    }

    public WeatherMainModel getWeatherMainModel() {
        return weatherMainModel;
    }

    public void setWeatherMainModel(WeatherMainModel weatherMainModel) {
        this.weatherMainModel = weatherMainModel;
    }
}
