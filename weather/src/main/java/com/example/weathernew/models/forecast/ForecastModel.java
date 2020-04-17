package com.example.weathernew.models.forecast;

import com.example.weathernew.models.weather.WeatherEntryModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class ForecastModel implements Serializable {

    private String name;
    private List<WeatherEntryModel> entries = new ArrayList<>();
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("entries")
    public List<WeatherEntryModel> getEntries() {
        return this.entries;
    }

    @JsonSetter("list")
    public void setEntries(List<WeatherEntryModel> entries) {
        this.entries = entries;
    }

    @JsonProperty("city")
    public void setCity(Map<String, Object> city) {
        setName(city.get("name").toString());
    }

}
