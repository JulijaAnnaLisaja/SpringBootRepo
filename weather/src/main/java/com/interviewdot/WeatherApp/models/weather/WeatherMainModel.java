package com.interviewdot.WeatherApp.models.weather;

import io.swagger.annotations.ApiModel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@ApiModel(description="Main entity of Weather Model class")
@Entity
public class WeatherMainModel {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal temp;

    public WeatherMainModel() {

    }

    public WeatherMainModel(Integer id, BigDecimal temp) {
        this.id = id;
        this.temp = temp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }
}
