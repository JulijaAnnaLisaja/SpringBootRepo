package com.example.weather.service;

import com.example.weather.models.ForecastModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Forecast component class, that contain save, findOne and deleteById methods
 *
 */
@Component
public class ForecastService {
    private static List<ForecastModel> forecasts = new ArrayList<>();

    private static int forecastCount = 3;

    static {
        forecasts.add(new ForecastModel(1, "290", "310", "123", "110" ));
        forecasts.add(new ForecastModel( 2, "285", "290", "143", "101"));
        forecasts.add(new ForecastModel( 3, "267", "310", "234", "111"));
    }

    /**
     *  Find all forecasts in database
     *
     * @return forecasts
     */
    public List<ForecastModel> findAll() {
        return forecasts;
    }

    /**
     * Add new forecast into database
     *
     * @param forecast new added parameter
     * @return forecast
     */
    public ForecastModel save(ForecastModel forecast) {
        // if user have an ID?
        if(forecast.getId()==null) {
            forecast.setId(++forecastCount);
        }
        forecasts.add(forecast);
        return forecast;
    }

    /**
     * Add new forecast into database
     *
     * @param id identification for the forecast
     * @return null
     */
    public ForecastModel findOne(int id) {
        // checking an array of users
        for(ForecastModel forecast : forecasts) {
            if(forecast.getId()==id) {
                return forecast;
            }
        }
        return null;
    }

    /**
     * Delete user by Id
     *
     * @param id identification for the forecast
     * @return null
     */
    public ForecastModel deleteById(int id) {
        Iterator<ForecastModel> iterator = forecasts.iterator();
        while(iterator.hasNext()) {
            ForecastModel user = iterator.next();
            if(user.getId()==id) {
                iterator.remove();
                return user;
            }
        }
        return null;
    }
}
