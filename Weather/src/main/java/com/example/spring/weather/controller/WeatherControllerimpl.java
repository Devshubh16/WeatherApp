package com.example.spring.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.spring.weather.logic.WeatherSearch;

@RestController
@RequestMapping("/api/v1")
public class WeatherControllerimpl {
	
	@Autowired
	WeatherSearch weatherSearch;
	
	@GetMapping(value ="/weather/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
	String getWeatherOfCity(@PathVariable("city")String city) {
		
		String json = weatherSearch.searchCityData(city);
		
		//JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

		return json;
	}
	
	@GetMapping(value ="/weather/hourly/{city}", produces = {MediaType.APPLICATION_JSON_VALUE})
	String getWeatherOfCityHourly(@PathVariable("city")String city) {
		
		String json = weatherSearch.searchCityData(city);
		
		//JsonObject convertedObject = new Gson().fromJson(json, JsonObject.class);

		return json;
	}
	
}
