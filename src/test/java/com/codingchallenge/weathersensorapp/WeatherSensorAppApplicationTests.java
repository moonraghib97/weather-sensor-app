package com.codingchallenge.weathersensorapp;

import com.codingchallenge.weathersensorapp.model.SensorDataModel;
import com.codingchallenge.weathersensorapp.repository.SensorDataRepository;
import com.codingchallenge.weathersensorapp.request.WeatherQueryRequest;
import com.codingchallenge.weathersensorapp.response.WeatherQueryResponse;
import com.codingchallenge.weathersensorapp.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@SpringBootTest
class WeatherSensorAppApplicationTests {

	@Mock
	private SensorDataRepository sensorDataRepository;

	@InjectMocks
	private WeatherService weatherService;

	@Test
	void testQuerySensorDataWithEmptyList() {
		WeatherQueryRequest request = new WeatherQueryRequest();
		request.setSensorIds(new ArrayList<>()); // Empty list
		request.setStartDate(convertToDate(LocalDateTime.now().minusDays(7)));
		request.setEndDate(convertToDate(LocalDateTime.now()));

		// Mocking repository response
		when(sensorDataRepository.findBySensorIdInAndTimestampBetween(
				request.getSensorIds(),
				request.getStartDate(),
				request.getEndDate()))
				.thenReturn(new ArrayList<>());

		// Call the service method
		WeatherQueryResponse response = weatherService.querySensorData(request);

		// Verify the response
		assertEquals(0.0, response.getAverageTemperature());
		assertEquals(0.0, response.getAverageHumidity());

	}

	@Test
	void testQuerySensorDataWithNonEmptyList() {
		WeatherQueryRequest request = new WeatherQueryRequest();
		request.setSensorIds(Arrays.asList("Sensor1", "Sensor2", "Sensor1"));
		request.setStartDate(convertToDate(LocalDateTime.now().minusDays(7)));
		request.setEndDate(convertToDate(LocalDateTime.now()));

		// Mocking repository response
		List<SensorDataModel> sensorDataList = Arrays.asList(
				new SensorDataModel("Sensor1", convertToDate(LocalDateTime.now().minusDays(6)), 25.0, 60.0),
				new SensorDataModel("Sensor2", convertToDate(LocalDateTime.now().minusDays(6)), 26.0, 55.0),
				new SensorDataModel("Sensor3", convertToDate(LocalDateTime.now().minusDays(6)), 24.0, 65.0)
		);
		when(sensorDataRepository.findBySensorIdInAndTimestampBetween(
				request.getSensorIds(),
				request.getStartDate(),
				request.getEndDate()))
				.thenReturn(sensorDataList);

		// Call the service method
		WeatherQueryResponse response = weatherService.querySensorData(request);

		// Verify the response
		assertEquals(25.0, response.getAverageTemperature());
		assertEquals(60.0, response.getAverageHumidity());

	}


	private static Date convertToDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
}
