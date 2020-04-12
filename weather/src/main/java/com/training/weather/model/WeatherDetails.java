package com.training.weather.model;

import javax.persistence.*;


@Entity
public class WeatherDetails {
    //TODO an entity for saving data in db (?????)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;
    String allDetails;


    public WeatherDetails(String allDetails) {
        this.allDetails = allDetails;
    }

    public Long getId() {
        return id;
    }

    public WeatherDetails(Long id, String allDetails) {
        this.id = id;
        this.allDetails = allDetails;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAllDetails() {
        return allDetails;
    }

    public void setAllDetails(String allDetails) {
        this.allDetails = allDetails;
    }


}
