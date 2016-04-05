package com.test;

import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.Test;

import com.restexample.WeatherService;

public class testWeatherService {
	WeatherService ws=new WeatherService();
@Test
public void test()throws Exception
{
	
	Response response=ws.getWeatherofCity("kansas");
	String output = (String) response.getEntity();
	JSONObject json = new JSONObject(output);
	
	int status = (int)json.getInt("cod");
	if (status != 200) {
		System.out.println("Error while accessing api, check input");
	}
	else
	{
		System.out.println("getWeather Executed");
	}
	
}

}
