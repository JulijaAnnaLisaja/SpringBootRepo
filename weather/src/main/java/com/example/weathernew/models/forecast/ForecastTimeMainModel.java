package com.example.weathernew.models.forecast;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@ApiModel(description="Main entity of Forecast Model class")
@Entity
@Getter
@Setter
public class ForecastTimeMainModel {
    @Id
    @GeneratedValue
    private Integer id;

    private BigDecimal temp;

    /**
     * Ieva, please, rename all of this variable
     * with @JsonProperty method, so
     * it matches the Java camelCase standards
     * Thanks
     */
    @JsonProperty("temp_min")
    private BigDecimal tempMin;
    @JsonProperty("temp_max")
    private BigDecimal tempMax;
    @JsonProperty("pressure")
    private BigDecimal pressure;
    @JsonProperty("sea_level")
    private BigDecimal seaLevel;
    @JsonProperty("grnd_level")
    private BigDecimal grndLevel;
    @JsonProperty("humidity")
    private BigDecimal humidity;
    @JsonProperty("temp_fk")
    private BigDecimal tempKf;
    @JsonProperty("username")
    private String username;

}
