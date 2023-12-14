package com.codingchallenge.weathersensorapp.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@Getter
@Setter
public class WeatherQueryResponse {

    private double averageTemperature;
    private double averageHumidity;

    private double minimumTemperature;
    private double minimumHumidity;


    public double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public double getAverageHumidity() {
        return averageHumidity;
    }

    public void setAverageHumidity(double averageHumidity) {
        this.averageHumidity = averageHumidity;
    }

    public double getMinimumTemperature() {
        return minimumTemperature;
    }

    public void setMinimumTemperature(double minimumTemperature) {
        this.minimumTemperature = minimumTemperature;
    }

    public double getMinimumHumidity() {
        return minimumHumidity;
    }

    public void setMinimumHumidity(double minimumHumidity) {
        this.minimumHumidity = minimumHumidity;
    }
}
