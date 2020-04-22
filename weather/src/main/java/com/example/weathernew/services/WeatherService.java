package com.example.weathernew.services;

import java.net.URI;
import java.util.concurrent.TimeUnit;

import com.alicp.jetcache.anno.Cached;
import com.example.weathernew.WeatherApiProperties;
import com.example.weathernew.models.weather.WeatherModel;
import com.example.weathernew.models.forecast.ForecastModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

@Service
public class WeatherService {

    private static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q={city},{country}&APPID={key}";

    private static final String FORECAST_URL =
            "http://api.openweathermap.org/data/2.5/forecast?q={city},{country}&APPID={key}";

    private final RestTemplate restTemplate;

    private final String apiKey;

    public WeatherService(RestTemplateBuilder restTemplateBuilder,
                          WeatherApiProperties properties) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = properties.getApi().getKey();
    }

    @Cached(name= "weather", expire = 10, timeUnit = TimeUnit.MINUTES)
    public WeatherModel getWeather(String country, String city) {
        URI url = new UriTemplate(WEATHER_URL).expand(city, country, this.apiKey);

        return invoke(url, WeatherModel.class);
    }

    @Cached(name= "forecast", expire = 10, timeUnit = TimeUnit.MINUTES)
    public ForecastModel getWeatherForecast(String country, String city) {
        URI url = new UriTemplate(FORECAST_URL).expand(city, country, this.apiKey);

        return invoke(url, ForecastModel.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }
}
