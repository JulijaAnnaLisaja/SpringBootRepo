package com.example.weathernew.models.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@ApiModel(description="Main entity of Location Model class")
@Entity
@Getter
@Setter
public class LocationModel {

    @Id
    @GeneratedValue
    private Integer id;

    @JsonProperty("lat")
    private String latitude;
    @JsonProperty("lon")
    private String longitude;
    private String timezone;
}
