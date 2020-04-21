package com.example.weathernew;
import com.example.weathernew.controllers.get.ForecastGetController;
import com.example.weathernew.services.ForecastService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ForecastGetController.class)
public class ServiceTests {

    @Autowired
    private MockMvc mvc;

    @MockBean(name="ForecastService")
    private ForecastService service;

    // write test cases here
    @Test
    public void getForecastRepository()
            throws Exception {

        ResponseEntity<?> resp = null;
        resp = service.forecastTemperatureAverage("Riga");
      mvc.perform(get("/weather/forecast/?city=Riga")
               .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());;

    }


}
