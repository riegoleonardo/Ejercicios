package com.despegar.jav.domain;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(HttpRequestService.class);

	public HttpRequestService() {

	}

	public String getFlightInformation(String url) {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		try {
			HttpGet request = new HttpGet(url);
			HttpResponse response = client.execute(request);
			HttpEntity entity = response.getEntity();
			return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			LOGGER.error("Error reading the Cheapest Flight Service", e);
			throw new ReadServiceException("There was an error retrieving cities.", e);
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				LOGGER.error("Error closing the connection with the Cheapest Flight Service", e);
			}
		}
	}
}
