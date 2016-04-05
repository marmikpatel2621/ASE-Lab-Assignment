package com.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.junit.Test;

import com.restexample.ShoppingMallFinder;


public class testShoppingMallFinder {

	ShoppingMallFinder shop=new ShoppingMallFinder();
	@Test
	public void test()throws Exception
	{
		
		Response response=shop.findShoppingofCity("!!!@@@");
		String output = (String) response.getEntity();
		JSONObject json = new JSONObject(output);
		JSONObject jsonMeta = json.getJSONObject("meta");
		int status = (int)jsonMeta.getInt("code");
		if (status != 200) {
			System.out.println("Error while accessing api, check input");
		}
		else
		{
			System.out.println("findShoppingList Executed");
		}
		
	}

}
