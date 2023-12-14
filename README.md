# Weather Sensor Service

## Overview
The Weather Sensor Service is a Spring Boot application designed to simulate a service for handling weather data from sensors. It provides functionality to query sensor data and receive new metric values through a user-friendly API

## Prerequisites

- Java 11 or higher
- Maven (for building the project)
- Postman
- Stable internet connection

## Getting Started
Follow these steps to get the Weather Sensor Service up and running on your local machine:

1. **Clone the repository:**

   ```bash
   git clone https://github.com/moonraghib97/weather-data-service.git
2. **Navigate to the project directory:**

   ```bash
   cd weather-data-service
3. **Build the project using Maven:**

   ```bash
   mvn clean install
4. **Run the application:**
   
   ```bash
   mvn spring-boot:run
The Weather Sensor Service will be accessible at http://localhost:8080.

API Endpoints
-------------

### 1\. Get Sensor Data

-   Endpoint: `/api/sensors/{sensorId}`
-   Method: GET
-   Description: Retrieve weather data for a specific sensor.
-   Example: `/api/sensors/123`

### 2\. Update Sensor Data

-   Endpoint: `/api/sensors/{sensorId}`
-   Method: POST
-   Description: Update weather data for a specific sensor.
-   Example Request Body:

    ```json
     {
      "metric": "temperature",
      "value": 25.5
     }
Configuration
-------------

You can customize the application by modifying the `application.properties` file.

## Using Postman

1.  Run Your Spring Boot Application:

    -   Ensure that your Spring Boot application is running.
2.  Open Postman:

    -   Open the Postman application on your computer.
3.  Create a New Request:

    -   Click on the "New" button to create a new request.
    -   Enter a request name (e.g., Weather API).
4.  Make a POST Request to Save Sensor Data:

    -   Set the request type to `POST`.
    -   Enter the URL: `http://localhost:8080/api/weather/add`.
    -   Switch to the "Body" tab and add a sample JSON payload for the `SensorDataModel`.
    -   Click on the "Send" button to execute the request.
    ```json
    {
    "sensorId": "sensor1000",
    "timestamp": "2022-12-17T12:00:00",
    "temperature": 60.5,
    "humidity": 30.5
    }
5.  Make a GET Request to Query Sensor Data:

    -   Set the request type to `GET`.
    -   Enter the URL: `http://localhost:8080/api/weather/query`.
    -   Switch to the "Body" tab and add a sample JSON payload for the `WeatherQueryRequest`.
    -   Click on the "Send" button to execute the request.
    ```json
    {
    "sensorIds": ["sensor50", "sensor1000"],
    "metrics": ["temperature", "humidity"],
    "statistic": "average",
    "startDate": "2021-12-01T00:00:00",
    "endDate": "2024-12-01T00:00:00"
    }
6.  View Responses:

    -   The response from the API will be displayed in the lower part of the Postman window.
    -   Check the status code, response body, and headers to verify the request's success.
    ```json
    {
    "averageTemperature": 40.5,
    "averageHumidity": 25.5,
    "minimumTemperature": 0.0,
    "minimumHumidity": 0.0
    }
7.  Modify Requests:

    -   Modify the request parameters, headers, and body as needed for different scenarios.

Now, you can use Postman to test and interact with your Weather Sensor Service API. Adjust the URLs and payloads based on your specific requirements.

Contributing
------------

If you would like to contribute to the Weather Sensor Service, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and submit a pull request.

Author
------------
Mamoon Raghib




