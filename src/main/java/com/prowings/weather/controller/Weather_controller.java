package com.prowings.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.prowings.weather.model.WeatherData;
import com.prowings.weather.responsedto.model.WeatherDataDto;
import com.prowings.weather.service.WeatherService;
import com.prowings.weather.service.WeatherService;

@RestController
public class Weather_controller {
	@Autowired
	WeatherService weatherService;
	
	
//	@GetMapping("/weather/{city}")
//	public ResponseEntity<WeatherData> getWeatherforCurrentCity(@PathVariable   String city){
//		
//		System.out.println("inside controller");
////		WeatherData data = new WeatherData();
////		String weatherdiscription = data.getWeather().get(0).getDescription();
//		return weatherService.currentcityWeather(city);
//		
//		
//	}
	
	@GetMapping("/weather/{city}")
	public ResponseEntity< WeatherDataDto> getWeatherforCurrentCity(@PathVariable   String city) throws JsonProcessingException{
		System.out.println("inside controller");
		return weatherService.currentcityWeather(city);
	}
}