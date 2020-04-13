package com.training.weather.service;



import com.training.weather.model.WeatherDetails;
import com.training.weather.repository.WeatherRepository;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;


@Service
@Transactional
public class WeatherDetailsService {

    @Autowired
    WeatherRepository customerRepository;


    public WeatherDetailsService() {

    }

    @Transactional
    public WeatherDetails setDetailsAboutRigaLV() {
      //TODO Implement save in db
     return null;
    }


}