package com.example.spring.weather.logic;

import com.example.spring.weather.handler.WeatherClientCallHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class WeatherSearch extends WeatherClientCallHandler{
	
	private static final Map<String, String> CITY_DATA_SUMMARY_CACHE = new ConcurrentHashMap<>();
	private static final Map<String, String> CITY_DATA_HOURLY_CACHE = new ConcurrentHashMap<>();
	
	
public String searchCityData(String queryparam) {
		
		String result = CITY_DATA_SUMMARY_CACHE.get(queryparam);
		
		if(result!=null) {
			
			return result;
		}
	
	
		StringBuilder sb =new StringBuilder();
		sb.append("https://forecast9.p.rapidapi.com/rapidapi/forecast/").append(queryparam).append("/summary/");
		
		String path = sb.toString();
		
		result = get(path);
		
		CITY_DATA_SUMMARY_CACHE.put(queryparam, result);
		
		return result;
		
	}
	
	public String searchCityDataForHour(String queryparam) {
		
		String result = CITY_DATA_HOURLY_CACHE.get(queryparam);
		
		if(result!=null) {
			
			return result;
		}
	
		
		StringBuilder sb =new StringBuilder();
		sb.append("https://forecast9.p.rapidapi.com/rapidapi/forecast/").append(queryparam).append("/hourly/");
		
		String path = sb.toString();
		
		result = get(path);
		
		CITY_DATA_HOURLY_CACHE.put(queryparam, result);
		
		return result;
			
		
	}
	

}
