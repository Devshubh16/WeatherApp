package com.example.spring.weather.handler;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.springframework.stereotype.Component;

@Component
public class WeatherClientCallHandler {
	
	public String get(String path){
		
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(path))
				.header("X-RapidAPI-Key", "9b4d8f3814msh754df55714a905cp18256ajsn7ef6a2906c45")
				.header("X-RapidAPI-Host", "forecast9.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = null;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(response.body());
		return response.body();
	}
	
	

}
