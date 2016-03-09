package com.despegar.jav.domain;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpRequestService {
  
	
	
	public HttpRequestService() {
		
	}
	
	
	//TODO RESPONSE DEL REQUEST!!!
	public String getFlightInformation(String url) {
		CloseableHttpClient  client = HttpClientBuilder.create().build();
		try {
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, "UTF-8");
		} catch (ClientProtocolException e) {
			throw new RuntimeException("There was an error retrieving cities.", e);
		} catch (IOException e) {
			throw new RuntimeException("There was an error retrieving cities.", e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				//TODO LOGGEAR!!!!
			}
		}
	}
}
