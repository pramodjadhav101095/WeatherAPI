package com.prowings.weather.service;

import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prowings.weather.exception.InvalidURLException;
import com.prowings.weather.model.WeatherData;
import com.prowings.weather.responsedto.model.WeatherDataDto;
import com.prowings.weather.utills.Location;
@Service
public class WeatherServiceImpl implements WeatherService {
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	DozerBeanMapper mapper;

	@Value("${base_url}")
	String baseUrl;

	@Value("${key}")
	String apiKey;

	double lat;
	double lon;
	
	ObjectMapper objMapper = new ObjectMapper();
	
//	@Override
//	public ResponseEntity<WeatherData> currentcityWeather(String city) {
//		
//		System.out.println("inside Serviceimpl");
//		
//		claculatelatlog(city);
//		
////https://api.openweathermap.org/data/2.5/weather?lat=18.6298&lon=73.7997&appid=aea2c2eaeb4020c7d96e8c22ce8d0bb2
//	String dynamicurl=	baseUrl+"?lat="+lat+"&lon="+lon+"&appid="+apiKey;
//	//String dynamicUrl2 = baseUrl+"?lat="+lat+"&lon="+lon+"&appid="+apiKey;
//		System.out.println(dynamicurl);
//		
//ResponseEntity<WeatherData> fetchweather =  restTemplate.getForEntity(dynamicurl,WeatherData.class ) ;
//		return fetchweather ;
//	}
//
//
private void claculatelatlog(String city) {
	
List<Double>latlon =Location.getlatlong().get(city);
lat  = latlon.get(0);
lon = latlon.get(1);
	
	
}
	@Override
	public ResponseEntity<WeatherDataDto> currentcityWeather(String city) throws JsonProcessingException {
		claculatelatlog(city);
		System.out.println("inside Serviceimpl");
	//	https://api.openweathermap.org/data/2.5/weather?lat=18.6298&lon=73.7997&appid=aea2c2eaeb4020c7d96e8c22ce8d0bb2
		String dynamicurl=	baseUrl+"?lat="+lat+"&lon=AA"+lon+"&appid="+apiKey;
		
		System.out.println(dynamicurl); 
		ResponseEntity<WeatherData> fetchweather = null;
		try {
		 fetchweather =  restTemplate.getForEntity(dynamicurl,WeatherData.class ) ;
		 
		}
		catch (Exception e) {
			
			//e.getMessage();
			throw new InvalidURLException();
			
			
			 
		}
		// MAPPING FETCHED WEATHER DATA TO WEATHERDATADTO
		
		String responseFromWeatherApi = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(fetchweather);
		System.out.println(">>>>>");
		System.out.println(responseFromWeatherApi);
		System.out.println("<<<<<");
		
		
		WeatherDataDto data = mapper.map(fetchweather.getBody(),WeatherDataDto.class );
		
		String jsonStr = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		System.out.println(">>>>>After DozerBean Mapper mapping :");
		System.out.println(jsonStr);
		System.out.println("<<<<<");
		return new ResponseEntity<WeatherDataDto>(data, HttpStatus.OK);
	}
}