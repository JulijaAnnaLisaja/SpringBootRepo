package com.example.weathernew.models.weather;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(description="Main entity of Weather Model class")
@Entity
@Getter
@Setter
public class WeatherModel extends WeatherEntryModel {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    public WeatherModel() {
    }

    public WeatherModel(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
