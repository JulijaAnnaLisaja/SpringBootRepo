package com.example.weather.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * A class that represent Forecast Entity
 *
 * Entity is not working for now
 */
//@Entity
public class ForecastModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String temp_min;    // min temperature
    private String temp_max;    // max temperature
    private String pressure;
    private String sea_level;

    //@OneToOne(fetch = FetchType.LAZY)
    // @JsonIgnore
    private WeatherModel forecast;

    public ForecastModel() {
    }

    public ForecastModel(Integer id, String temp_min, String temp_max, String pressure, String sea_level) {
        this.id = id;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.pressure = pressure;
        this.sea_level = sea_level;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(String temp_min) {
        this.temp_min = temp_min;
    }

    public String getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(String temp_max) {
        this.temp_max = temp_max;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getSea_level() {
        return sea_level;
    }

    public void setSea_level(String sea_level) {
        this.sea_level = sea_level;
    }

    /**
     * Convert all records into string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ForecastModel{" +
                "id=" + id +
                ", temp_min='" + temp_min + '\'' +
                ", temp_max='" + temp_max + '\'' +
                ", pressure='" + pressure + '\'' +
                ", sea_level='" + sea_level + '\'' +
                ", forecast=" + forecast +
                '}';
    }

    public WeatherModel getForecast() {
        return forecast;
    }

    public void setForecast(WeatherModel forecast) {
        this.forecast = forecast;
    }
}
