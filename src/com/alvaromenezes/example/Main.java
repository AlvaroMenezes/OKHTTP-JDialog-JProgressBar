package com.alvaromenezes.example;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

	public static void main(String[] args) throws IOException {
		

        String url = "http://api.wunderground.com/api/57dd9039b81a9c21/conditions/q/CA/San_Francisco.json";
		
		  OkHttpClient client = new OkHttpClient();
	        Request request = new Request.Builder()
	                .url(url)
	                .build();

	        Response response = client.newCall(request).execute();
	        System.out.println( response.body().string());
	}

}
