package com.codingchallenge.weathersensorapp.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author Mamoon Raghib
 * @since 15/12/2023
 */

@Setter
@Getter
public class WeatherQueryRequest {

    @NotEmpty(message = "At least one sensorId must be provided")
    private List<String> sensorIds;

    @NotEmpty(message = "At least one metric must be provided")
    private List<String> metrics;

    @NotEmpty(message = "Statistic must be provided")
    private String statistic;

    @NotNull(message = "startDate cannot be null")
    private Date startDate;

    @NotNull(message = "endDate cannot be null")
    private Date endDate;

    public List<String> getSensorIds() {
        return sensorIds;
    }

    public void setSensorIds(List<String> sensorIds) {
        this.sensorIds = sensorIds;
    }

    public List<String> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<String> metrics) {
        this.metrics = metrics;
    }

    public String getStatistic() {
        return statistic;
    }

    public void setStatistic(String statistic) {
        this.statistic = statistic;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
