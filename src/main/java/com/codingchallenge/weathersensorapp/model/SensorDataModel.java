package com.codingchallenge.weathersensorapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@Entity
public class SensorDataModel {


    //This is the model class used for persisting data

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sensorId;

    private Date timestamp;

    private double temperature;

    private double humidity;

    public SensorDataModel() {
    }

    public SensorDataModel(String sensor1, Date localDateTime, double v, double v1) {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }




    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
}
