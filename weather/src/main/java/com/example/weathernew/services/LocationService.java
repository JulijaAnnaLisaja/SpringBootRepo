package com.example.weathernew.services;

import com.alicp.jetcache.anno.Cached;
import com.example.weathernew.WeatherApiProperties;
import com.example.weathernew.models.location.LocationModel;
import com.example.weathernew.models.weather.WeatherModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class LocationService {
    private static final String LOCATION_URL =
            "http://api.openweathermap.org/data/2.5/onecall?lat={lat}&lon={lon}&APPID={key}";

    private final RestTemplate restTemplate;

    private final String apiKey;

    public LocationService(RestTemplateBuilder restTemplateBuilder,
                          WeatherApiProperties properties) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = properties.getApi().getKey();
    }

    @Cached(name= "weather", expire = 10, timeUnit = TimeUnit.MINUTES)
    public LocationModel getLocation(String lat, String lon) {
        URI url = new UriTemplate(LOCATION_URL).expand(lat, lon, this.apiKey);

        return invoke(url, LocationModel.class);
    }

    private <T> T invoke(URI url, Class<T> responseType) {
        RequestEntity<?> request = RequestEntity.get(url).accept(MediaType.APPLICATION_JSON).build();
        ResponseEntity<T> exchange = this.restTemplate.exchange(request, responseType);
        return exchange.getBody();
    }

}
