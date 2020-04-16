package com.interviewdot.WeatherApp.controller.get;

import com.interviewdot.WeatherApp.models.weather.WeatherMainModel;
import com.interviewdot.WeatherApp.models.weather.WeatherResponseModel;
import com.interviewdot.WeatherApp.repostories.WeatherRepository;
import com.interviewdot.WeatherApp.services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class WeatherController {
    static String apiKey = "f42afabb07138b319e71a4d8d6a08809";
    static RestTemplate restTemplate = new RestTemplate();
    static HttpHeaders headers = new HttpHeaders();

    @Autowired
    private WeatherRepository weatherRepository;

    /**
     * Allows to get OpenWeather "/weather" from country and city
     *
     * @param city the city name, that allows to get weather data
     * @param country the country, that allows to get weather data
     * @return response
     */
    @RequestMapping(method = RequestMethod.GET, value = "/weatherTemp/{country}/{city}")
    public @ResponseBody
    Object getWeatherTempByCountryCity(@PathVariable String city, @PathVariable String country) {

        ResponseEntity<WeatherMainModel> response = restTemplate.
                getForEntity("http://api.openweathermap.org/data/2.5/weather?q=" + city + "," + country + "&APPID="+ apiKey + "&units=metric",
                        WeatherMainModel.class);
        return response.getBody().getTemp();
    }
}
