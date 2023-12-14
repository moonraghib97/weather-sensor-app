package com.codingchallenge.weathersensorapp.service;

import com.codingchallenge.weathersensorapp.model.SensorDataModel;
import com.codingchallenge.weathersensorapp.request.WeatherQueryRequest;
import com.codingchallenge.weathersensorapp.response.WeatherQueryResponse;

import java.util.Date;
import java.util.List;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

public interface WeatherService {


    //This method is used for querying Sensor Data and Accepting Weather Query Rest as input
    WeatherQueryResponse querySensorData(WeatherQueryRequest queryRequest);


    //this method is used for persisting data into database
    void saveSensorData(SensorDataModel sensorData);
}
