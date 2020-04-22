package com.example.weathernew;

import com.example.weathernew.controllers.get.ForecastGetController;
import com.example.weathernew.models.forecast.ForecastAverageModel;
import com.example.weathernew.models.location.LocationModel;
import com.example.weathernew.models.weather.WeatherModel;
import com.example.weathernew.services.ForecastService;
import com.example.weathernew.services.LocationService;
import com.example.weathernew.services.WeatherService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ForecastGetController.class)
public class ServiceTests {

    @Autowired
    private MockMvc mvc;

    @MockBean(name = "ForecastService")
    private ForecastService service;

    @MockBean(name = "LocationService")
    private LocationService locationService;

    @MockBean(name = "WeatherService")
    private WeatherService weatherService;

    Logger logger = LoggerFactory.getLogger(WeatherIntegrationTests.class);

    @Test
    public void getForecastRepository()
            throws Exception {

        ResponseEntity<?> resp = null;
        resp = service.forecastTemperatureAverage("Riga");
        mvc.perform(get("/weather/forecast/?city=Riga")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        logger.info("----- getForecastRepository() finished successfully");

    }

    public void getLocationRepository()
            throws Exception {

        LocationModel resp = null;
        resp = locationService.getLocation("1.0", "1.0");
        mvc.perform(get("/location/get/?lat=1/?lon=1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        ;

    }


    public void getWeatherRepository()
            throws Exception {

        WeatherModel resp = null;
        resp = weatherService.getWeather("Latvia", "Riga");
        mvc.perform(get("/weather/now/Latvia/Riga")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        ;

    }


    @Test
    public void getForecastRepositoryEx()
            throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        List<ForecastAverageModel> participantJsonList = null;
        try {
            ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:8080/weather/forecast?city=Riga1", String.class);
            ObjectMapper mapper = new ObjectMapper();
            mapper.findAndRegisterModules();

            participantJsonList = mapper.readValue((String) response.getBody(), new TypeReference<List<ForecastAverageModel>>() {

            });
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            assertThat(e.equals(HttpClientErrorException.NotFound.class));
            logger.info("----- getForecastRepositoryEx() finished successfully");
        }


    }


}
