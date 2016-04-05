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

@Path("/shoppingmall")
public class ShoppingMallFinder {
/*	@GET
	@Produces("application/json")
	public Response findShopping() throws JSONException {

		String output = null;
		try {

			Client client = Client.create();
			WebResource web = client.resource("https://api.foursquare.com/v2/venues/search"
					+ "?client_id=3PPNMTIKJJNDVYPFOBGSHHV2PR5A2P05PYHXDN2MKSKTTBSX"
					+ "&client_secret=0QPHT0F5RS043F4TB4KKPQSHKSAXKE5ZNOYGB5KL2MBDYAG4" + "&v=20160215&limit=1"
					+ "&near=kansas" + "&query=shopping");
			ClientResponse response = web.accept("application/json").get(ClientResponse.class);
			output = response.getEntity(String.class);
			JSONObject json = new JSONObject(output);
			JSONObject jsonMeta = json.getJSONObject("meta");
			int status = (int)jsonMeta.getInt("code");
			if (status != 200) {
				response = null;
				throw new RuntimeException("Failed : HTTP error code : " + status);
			}
 
			System.out.println(output + response.getStatus());
					} catch (Exception e) {
		}
		return Response.status(200).entity(output).build();

	}*/

	@Path("{city}")
	@GET
	@Produces("application/json")
	public Response findShoppingofCity(@PathParam("city") String city) throws JSONException {

		String output = null;
		try {

			Client client = Client.create();
			WebResource web = client.resource("https://api.foursquare.com/v2/venues/search" +
                "?client_id=3PPNMTIKJJNDVYPFOBGSHHV2PR5A2P05PYHXDN2MKSKTTBSX" +
                "&client_secret=0QPHT0F5RS043F4TB4KKPQSHKSAXKE5ZNOYGB5KL2MBDYAG4" +
                "&v=20160215&limit=1" +
                "&near=" + city +
                "&query=shopping");
			ClientResponse response = web.accept("application/json").get(ClientResponse.class);
			output = response.getEntity(String.class);
			
			System.out.println(output + response.getStatus());
		} catch (Exception e) {
			
		}	
	
		return Response.status(200).entity(output).build();

	}
}
