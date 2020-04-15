package com.interviewdot.WeatherApp.models.location;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(description="Main entity of Location Model class")
@Entity
public class LocationMainModel {
    @Id
    @GeneratedValue
    private Integer id;

}
