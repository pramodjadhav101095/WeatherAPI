package com.prowings.weather.service;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prowings.weather.model.WeatherData;
import com.prowings.weather.responsedto.model.WeatherDataDto;

public interface WeatherService {

//	ResponseEntity<WeatherData> currentcityWeather(String city);
	
	ResponseEntity<WeatherDataDto> currentcityWeather(String city) throws JsonProcessingException;

}
