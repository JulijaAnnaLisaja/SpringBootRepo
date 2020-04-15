package com.interviewdot.WeatherApp.services;

import com.interviewdot.WeatherApp.models.forecast.ForecastAverageModel;
import com.interviewdot.WeatherApp.models.forecast.ForecastModel;
import com.interviewdot.WeatherApp.models.forecast.ForecastMapTimeModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import springfox.documentation.spring.web.json.Json;
import com.alicp.jetcache.anno.Cached;

@Service
public class ForecastService {
    private final String uri = "http://api.openweathermap.org/data/2.5/forecast";
    private final String key = "f42afabb07138b319e71a4d8d6a08809";
    private final RestTemplate restTemplate;

    public ForecastService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
    public ResponseEntity<?> forecastTemperatureAverage(String city) {
        List<ForecastAverageModel> result = new ArrayList<ForecastAverageModel>();

        try {
            ForecastModel weatherMap = this.restTemplate.getForObject(this.url(city), ForecastModel.class);

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
        return String.format(uri.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, key);
    }
}
