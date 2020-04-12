package com.example.weather.models;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;

/**
 * A class that represent Weather Entity
 *
 * Entity is not working for now
 */
//@ApiModel(description="Simple Weather Entity")
//@Entity
public class WeatherModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String temp;
    private String main;
    private String description;
    private String icon;

    //@OneToOne(fetch = FetchType.LAZY)
    //@JsonIgnore
    private ForecastModel forecast;

    //Empty constructor
    public WeatherModel() {
    }

    public WeatherModel(Integer id, String temp, String main, String description, String icon) {
        this.id = id;
        this.temp = temp;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Convert all records into string
     *
     * @return String
     */
    @Override
    public String toString() {
        return "WeatherModel{" +
                "id=" + id +
                ", temp='" + temp + '\'' +
                ", main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", forecast=" + forecast +
                '}';
    }

    public ForecastModel getForecast() {
        return forecast;
    }

    public void setForecast(ForecastModel forecast) {
        this.forecast = forecast;
    }
}
