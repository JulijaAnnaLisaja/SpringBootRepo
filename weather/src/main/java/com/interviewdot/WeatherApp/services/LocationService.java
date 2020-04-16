package com.interviewdot.WeatherApp.services;

public class LocationService {
    /*
    private final String uri = "http://api.openweathermap.org/data/2.5/forecast";
    private final String key = "f42afabb07138b319e71a4d8d6a08809";
    private final RestTemplate restTemplate;

    public LocationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Cached(expire = 10, timeUnit = TimeUnit.MINUTES)
    public ResponseEntity<?> locationTemperature(String city) {
        List<LocationResponseModel> result = new ArrayList<LocationResponseModel>();

        LocationResponseModel locationResponseModel = this.restTemplate.getForObject(this.url(city), LocationResponseModel.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    /**
     *
     * @param city
     * @return url
     *
    private String url(String city) {
        return String.format(uri.concat("?q=%s").concat("&appid=%s").concat("&units=metric"), city, key);
    }
    */
}
