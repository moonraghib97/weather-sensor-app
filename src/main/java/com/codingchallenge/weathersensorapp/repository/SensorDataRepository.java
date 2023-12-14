package com.codingchallenge.weathersensorapp.repository;

import com.codingchallenge.weathersensorapp.model.SensorDataModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@Repository
public interface SensorDataRepository extends JpaRepository<SensorDataModel, Long> {
    List<SensorDataModel> findBySensorIdAndTimestampBetween(String sensorId, Date start, Date end);

    List<SensorDataModel> findBySensorIdInAndTimestampBetween(List<String> sensorIds, Date startDate, Date endDate);

}
