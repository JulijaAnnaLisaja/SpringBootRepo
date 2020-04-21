package com.example.weathernew.services;

import com.alicp.jetcache.anno.Cached;
import com.example.weathernew.WeatherApiProperties;

import com.example.weathernew.models.forecast.ForecastAverageModel;
import com.example.weathernew.models.forecast.ForecastMapTimeModel;
import com.example.weathernew.models.forecast.ForecastMessageModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ForecastService {

    private static final String FORECAST_URL =
            "http://api.openweathermap.org/data/2.5/forecast";

    private final RestTemplate restTemplate;

    private final String apiKey;

    public ForecastService(RestTemplateBuilder restTemplateBuilder,
                           WeatherApiProperties properties) {
        this.restTemplate = restTemplateBuilder.build();
        this.apiKey = properties.getApi().getKey();
    }

    @Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
    public ResponseEntity<?> forecastTemperatureAverage(String city) {
        List<ForecastAverageModel> result = new ArrayList<ForecastAverageModel>();

        try {
            ForecastMessageModel weatherMap = this.restTemplate.getForObject(this.url(city), ForecastMessageModel.class);

            for (LocalDate reference = LocalDate.now();
                 reference.isBefore(LocalDate.now().plusDays(7));
                 reference = reference.plusDays(1)) {
                final LocalDate ref = reference;

                List<ForecastMapTimeModel> collect = weatherMap.getList().stream()
                        .filter(x -> x.getDt().toLocalDate().equals(ref)).collect(Collectors.toList());
                if (!CollectionUtils.isEmpty(collect)) {
                    result.add(this.average(collect));
                }
            }
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(new Json(e.getResponseBodyAsString()), e.getStatusCode());
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    private ForecastAverageModel average(List<ForecastMapTimeModel> list) {
        ForecastAverageModel result = new ForecastAverageModel();

        for (ForecastMapTimeModel item : list) {
            result.setDate(item.getDt().toLocalDate());
            result.plusMap(item);
        }

        result.totalize();
        return result;
    }

    private String url(String city) {
        return String.format(FORECAST_URL.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, apiKey);
    }
}
