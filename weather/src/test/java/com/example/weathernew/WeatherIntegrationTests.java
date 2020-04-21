package com.example.weathernew;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.weathernew.models.forecast.ForecastAverageModel;
import com.example.weathernew.models.forecast.ForecastTimeMainModel;
import org.json.JSONObject;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class WeatherIntegrationTests {
    JsonNode responseJson;
    static RestTemplate restTemplate;
    static HttpHeaders headers;
    static JSONObject personJsonObject;
    Logger logger = LoggerFactory.getLogger(WeatherIntegrationTests.class);



    @Test
    public void test1GetForecastEndpointWithOneParameter() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/weather/forecast?city=Riga", String.class);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
        logger.info("----- testGetForecastEndpointWithOneParameter() finished successfully");
    }

    @Test
    public void test2PostForecastEndpointWithParameters() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        ForecastTimeMainModel w = new ForecastTimeMainModel();
        ReflectionTestUtils.setField(w, "tempMax", new BigDecimal(5));
        ReflectionTestUtils.setField(w, "tempMin", new BigDecimal(6));
        ReflectionTestUtils.setField(w, "temp", new BigDecimal(7));
        ReflectionTestUtils.setField(w, "seaLevel", new BigDecimal(8));
        ReflectionTestUtils.setField(w, "humidity", new BigDecimal(9));
        ReflectionTestUtils.setField(w, "grndLevel", new BigDecimal(10));
        ReflectionTestUtils.setField(w, "pressure", new BigDecimal(11));
        ReflectionTestUtils.setField(w, "tempKf", new BigDecimal(12));
        //w.setUsername("ddd");
        restTemplate.httpEntityCallback(w);
        ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/forecast/forecast", w, String.class);
        System.out.println("------------------" + response.getStatusCode());
      //  assert (response.getStatusCode()).equals(HttpStatus.CREATED);
        logger.info("----- testPostForecastEndpointWithParameter() finished successfully");

    }


    @Test
    public void test3GetWeatherEndpointWithOneParameter() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/weather/now/Latvia/Riga", String.class);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
        logger.info("-----  testGetWeatherEndpointWithOneParameter() finished successfully");
    }

    @Test
    public void test4getAndSave() {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<?> response = restTemplate.getForEntity("http://localhost:8080/weather/forecast?city=Riga", String.class);
        ObjectMapper mapper = new ObjectMapper();
        List<ForecastAverageModel> participantJsonList = null;
        mapper.findAndRegisterModules();
        try {
            participantJsonList = mapper.readValue((String) response.getBody(), new TypeReference<List<ForecastAverageModel>>() {

            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        ForecastTimeMainModel w = new ForecastTimeMainModel();
        ReflectionTestUtils.setField(w, "tempMin", ReflectionTestUtils.getField(participantJsonList.get(0),"nightly"));
      //  w.setTempMin(participantJsonList.get(0).getNightly());
      //  w.setTempMax(participantJsonList.get(0).getDaily());
      //  w.setUsername("testuser");

        assert (response.getStatusCode()).equals(HttpStatus.OK);


        ResponseEntity<String> response2 = restTemplate.postForEntity("http://localhost:8080/forecast/forecast", w, String.class);
        //  ResponseEntity<String> response2 = restTemplate.postForEntity("http://localhost:8080/weather/forecast" ,String.class);
        System.out.println("------------------" + response.getStatusCode());
        assert (response2.getStatusCode()).equals(HttpStatus.CREATED);
        logger.info("----- getAndSave() finished successfully");


    }

    @Test
    public void test5GetLocationEndpointWithOneParameter() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/location/get/1.0/1.0", String.class);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
        logger.info("-----  testLocationEndpointWithOneParameter() finished successfully");
    }

    @Test
    public void test6GetWeatherNowEndpointWithOneParameter() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/weather/now/Latvia/Riga", String.class);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
        logger.info("-----  testLocationEndpointWithOneParameter() finished successfully");
    }

    @Test
    public void test7GetWeatherWeeklyEndpointWithOneParameter() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/weather/weekly/Latvia/Riga", String.class);
        assert (response.getStatusCode()).equals(HttpStatus.OK);
        logger.info("-----  testLocationEndpointWithOneParameter() finished successfully");
    }


}
