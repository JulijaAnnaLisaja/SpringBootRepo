package com.interviewdot.WeatherApp.models.weather;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(description="Main entity of Weather Model class")
@Entity
public class WeatherMainModel {
    @Id
    @GeneratedValue
    private Integer id;
}
