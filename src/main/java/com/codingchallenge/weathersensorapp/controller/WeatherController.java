package com.codingchallenge.weathersensorapp.controller;

import com.codingchallenge.weathersensorapp.model.SensorDataModel;
import com.codingchallenge.weathersensorapp.repository.SensorDataRepository;
import com.codingchallenge.weathersensorapp.request.WeatherQueryRequest;
import com.codingchallenge.weathersensorapp.response.WeatherQueryResponse;
import com.codingchallenge.weathersensorapp.service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@RestController
@RequestMapping("/api/weather")
public class WeatherController {


    @Autowired
    private WeatherService weatherService;


    //this is the post method to save/persist data.
    @PostMapping("/add")
    public ResponseEntity<String> addSensorData(@RequestBody SensorDataModel sensorData) {
        try {
            weatherService.saveSensorData(sensorData);
            return ResponseEntity.ok("Data added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding data");
        }
    }



    @GetMapping("/query")
    public ResponseEntity<WeatherQueryResponse> querySensorData(@Valid @RequestBody WeatherQueryRequest request) {
        try {
            WeatherQueryResponse response = weatherService.querySensorData(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

}
