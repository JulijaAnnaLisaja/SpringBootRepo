package com.example.weathernew.models.forecast;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ForecastMapTimeModel {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonProperty("dt_txt")
    private LocalDateTime dt;
    private ForecastTimeMainModel main;

    @JsonIgnore
    public Boolean isDaily() {
        return (this.dt.getHour() >= 6 && this.dt.getHour() < 18);
    }

}