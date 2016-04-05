package com.restexample;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@Path("/weatherservice")
public class WeatherService {
	  @Path("{city}")
	  @GET
	  @Produces("application/json")
	  public Response getWeatherofCity(@PathParam("city") String city) throws JSONException {
		  
		  String output = null;
		  try {
			  
				Client client = Client.create();
				WebResource web = client.resource("http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=44db6a862fba0b067b1930da0d769e98");
				ClientResponse response = web.accept("application/json").get(ClientResponse.class);
				
				
				output = response.getEntity(String.class);
				
				System.out.println(output);
				
				
			} catch (Exception e) {
				
			}	
		  return Response.status(200).entity(output).build();
			
  }
}
