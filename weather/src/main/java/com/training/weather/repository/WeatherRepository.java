package com.training.weather.repository;


import java.util.List;


import com.training.weather.model.WeatherDetails;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<WeatherDetails, Long> {
    List<WeatherDetails> findAll();


    //TODO: Add code that will be necessary to implement all methods in service for db
    //@Modifying
    // @Query("update Customer u set u.firstName = ?1, u.lastName = ?2 where u.id = ?3")
    // void setUserInfoById( String firstname, String lastname,Long id);

}