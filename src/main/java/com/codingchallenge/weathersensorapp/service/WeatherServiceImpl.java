package com.codingchallenge.weathersensorapp.service;

import com.codingchallenge.weathersensorapp.model.SensorDataModel;
import com.codingchallenge.weathersensorapp.repository.SensorDataRepository;
import com.codingchallenge.weathersensorapp.request.WeatherQueryRequest;
import com.codingchallenge.weathersensorapp.response.WeatherQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private SensorDataRepository sensorDataRepository;


    //this is the implementation of service method querying sensor data
    // this method is calculating average temperature and humidity
    @Override
    public WeatherQueryResponse querySensorData(WeatherQueryRequest request) {

        List<SensorDataModel> sensorDataList = sensorDataRepository.findBySensorIdInAndTimestampBetween(
                request.getSensorIds(),
                request.getStartDate(),
                request.getEndDate()
        );

        double totalTemperature = 0.0;
        double totalHumidity = 0.0;

        double minTemperature = Double.MAX_VALUE;
        double minHumidity = Double.MAX_VALUE;

        for (SensorDataModel sensorData : sensorDataList) {
            totalTemperature += sensorData.getTemperature();
            totalHumidity += sensorData.getHumidity();

            // Update minimum values
            minTemperature = Math.min(minTemperature, sensorData.getTemperature());
            minHumidity = Math.min(minHumidity, sensorData.getHumidity());
        }

        int dataSize = sensorDataList.size();
        double averageTemperature = dataSize > 0 ? totalTemperature / dataSize : 0.0;
        double averageHumidity = dataSize > 0 ? totalHumidity / dataSize : 0.0;

        WeatherQueryResponse response = new WeatherQueryResponse();

        if(request.getStatistic().equals("min")){
            response.setMinimumTemperature(minTemperature);
            response.setMinimumHumidity(minHumidity);

        }else if(request.getStatistic().equals("average")){
            response.setAverageTemperature(averageTemperature);
            response.setAverageHumidity(averageHumidity);
        }

        return response;
    }


    //this method is the implementation of saving data
    @Override
    public void saveSensorData(SensorDataModel sensorData) {
        sensorDataRepository.save(sensorData);
    }
}
