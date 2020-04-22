package com.example.weathernew;

import com.example.weathernew.models.forecast.ForecastMapTimeModel;
import com.example.weathernew.models.forecast.ForecastMessageModel;
import com.example.weathernew.models.forecast.ForecastModel;
import com.example.weathernew.models.forecast.ForecastTimeMainModel;
import com.example.weathernew.models.location.LocationModel;
import com.example.weathernew.models.weather.WeatherEntryModel;
import com.example.weathernew.models.weather.WeatherModel;
import com.example.weathernew.models.weather.WeatherSummaryModel;
import com.example.weathernew.repositories.ForecastRepository;
import com.example.weathernew.services.ForecastService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.math.BigDecimal;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest
@ContextConfiguration
class WeatherAppApplicationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ForecastRepository forecast;

    Logger logger = LoggerFactory.getLogger(WeatherAppApplicationTests.class);
    ForecastTimeMainModel wtmm = new ForecastTimeMainModel();
    ForecastModel fm = new ForecastModel();


    @Test
    @Order(1)
    public void testInsertForecast() {
        ReflectionTestUtils.setField(wtmm, "tempMax", new BigDecimal(5));
        ReflectionTestUtils.setField(wtmm, "tempMin", new BigDecimal(6));
        ReflectionTestUtils.setField(wtmm, "temp", new BigDecimal(7));
        ReflectionTestUtils.setField(wtmm, "seaLevel", new BigDecimal(8));
        ReflectionTestUtils.setField(wtmm, "humidity", new BigDecimal(9));
        ReflectionTestUtils.setField(wtmm, "grndLevel", new BigDecimal(10));
        ReflectionTestUtils.setField(wtmm, "pressure", new BigDecimal(11));
        ReflectionTestUtils.setField(wtmm, "tempKf", new BigDecimal(12));
        entityManager.persist(wtmm);
        ForecastTimeMainModel wtmmL = forecast.save(wtmm);
        assertThat(ReflectionTestUtils.getField(wtmm, "tempMax")).isEqualTo(ReflectionTestUtils.getField(wtmmL, "tempMax"));
        logger.info("----- testInsertForecast()  finished successfully" + "Saved: " + ReflectionTestUtils.getField(wtmmL, "tempMax").toString());
    }

    @Test
    @Order(2)
    public void readForecast() {
        entityManager.persist(wtmm);
        Optional<ForecastTimeMainModel> wtmmL = forecast.findById((Integer) ReflectionTestUtils.getField(wtmm, "id"));
        assertThat(wtmmL).isNotEmpty();
        logger.info("----- readForecast() finished successfully");
    }

    @Test
    @Order(3)
    public void updateForecast() {
        entityManager.persist(wtmm);
        Optional<ForecastTimeMainModel> wtmmL = forecast.findById((Integer) ReflectionTestUtils.getField(wtmm, "id"));
        ForecastTimeMainModel ftmm = wtmmL.get();
        ReflectionTestUtils.setField(wtmm, "tempMax", new BigDecimal(9));
        ReflectionTestUtils.setField(wtmm, "tempMin", new BigDecimal(6));
        ReflectionTestUtils.setField(wtmm, "temp", new BigDecimal(7));
        ReflectionTestUtils.setField(wtmm, "seaLevel", new BigDecimal(8));
        ReflectionTestUtils.setField(wtmm, "humidity", new BigDecimal(9));
        ReflectionTestUtils.setField(wtmm, "grndLevel", new BigDecimal(10));
        ReflectionTestUtils.setField(wtmm, "pressure", new BigDecimal(11));
        ReflectionTestUtils.setField(wtmm, "tempKf", new BigDecimal(12));
        ForecastTimeMainModel savedFtmm = forecast.save(ftmm);
        assertThat(ReflectionTestUtils.getField(wtmm, "tempMax")).isEqualTo(ReflectionTestUtils.getField(savedFtmm, "tempMax"));
        logger.info("----- updateForecast() finished successfully" + "Updated: " + ReflectionTestUtils.getField(savedFtmm, "tempMax"));
        // System.out.println(savedFtmm.getTemp_max()+" -----------------");
    }

    @Test
    @Order(4)
    public void readForecastAfterUpdate() {
        entityManager.persist(wtmm);
        Optional<ForecastTimeMainModel> wtmmL = forecast.findById((Integer) ReflectionTestUtils.getField(wtmm, "id"));
        assertThat(wtmmL).isNotEmpty();
        logger.info("----- readForecastAfterUpdate() finished successfully" + wtmmL.get());
    }

    @Test
    @Order(5)
    public void deleteForecast() {
        entityManager.persist(wtmm);
        assertThat(wtmm).isNotNull();
        ReflectionTestUtils.setField(wtmm, "tempMax", new BigDecimal(5));

        forecast.deleteById((Integer) ReflectionTestUtils.getField(wtmm, "id"));
        Optional<ForecastTimeMainModel> wtmmL = forecast.findById((Integer) ReflectionTestUtils.getField(wtmm, "id"));
        assertThat(wtmmL).isEmpty();
        logger.info("----- deleteForecast() finished successfully");
    }


    @Test
    @Order(6)
    public void testGetAllForecast() {
        ForecastTimeMainModel wtmm = new ForecastTimeMainModel();
        entityManager.persist(wtmm);

        List<ForecastTimeMainModel> wtmmL = forecast.findAll();
        assertThat(!wtmmL.isEmpty());
        logger.info("----- testGetAllForecast() finished successfully");
    }


    //TODO test services
    @Test
    @Order(9)
    public void getForecastServiceMethod() {

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        WeatherApiProperties sss = new WeatherApiProperties();
        ForecastService forecastService = new ForecastService(restTemplateBuilder, sss);

        forecastService.forecastTemperatureAverage("Riga");


        ResponseEntity<String> re = (ResponseEntity<String>) forecastService.forecastTemperatureAverage("Riga");
        assertThat(re.getStatusCode().equals(HttpStatus.OK));
        logger.info("----- getForecastServiceMethod() finished successfully");
    }

    @Test
    @Order(9)
    public void setWeatherSummaryModel() {
        WeatherModel weather = new WeatherModel();
        ReflectionTestUtils.setField(weather, "temperature", 1);
        WeatherEntryModel weatherEntries = new WeatherEntryModel();
        List l = new ArrayList();
        Map<String, Object> map = new HashMap<String, Object>();
        //l.add(weatherEntries);
        map.put("1", weatherEntries);
        l.add(map);
        weather.setWeather(l);
        ReflectionTestUtils.setField(weather, "name", "Latvia");

        WeatherSummaryModel wsm = new WeatherSummaryModel(" Latvia", "Riga", weather);
        ReflectionTestUtils.setField(wsm, "country", "Latvia");
        ReflectionTestUtils.setField(wsm, "city", "Latvia");
    }

    @Test
    @Order(10)
    public void setLocationSummaryModel() {
        LocationModel lm = new LocationModel();
        ReflectionTestUtils.setField(lm, "latitude", "1.0");
        ReflectionTestUtils.setField(lm, "longitude", "1.0");

    }

    @Test
    @Order(11)
    public void setForecastModel() {
        ForecastMapTimeModel fmtm = new ForecastMapTimeModel();
        ForecastTimeMainModel ftmm = new ForecastTimeMainModel();
        ReflectionTestUtils.setField(fmtm, "main", ftmm);

        ForecastMessageModel fmm = new ForecastMessageModel();
        List<ForecastMapTimeModel> lfmtm = new ArrayList<>();
        lfmtm.add(fmtm);
        ReflectionTestUtils.setField(fmm, "list", lfmtm);
        ReflectionTestUtils.setField(fmm, "cod", "ddd");
        ReflectionTestUtils.setField(fmm, "message", new BigDecimal(5));
        ReflectionTestUtils.setField(fmm, "cnt", 8);


    }


}
