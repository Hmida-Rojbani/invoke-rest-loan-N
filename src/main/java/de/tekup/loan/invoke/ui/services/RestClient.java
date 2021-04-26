package de.tekup.loan.invoke.ui.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import de.tekup.loan.invoke.ui.types.CustomerRequest;
import de.tekup.loan.invoke.ui.types.WsResponse;

@Service
public class RestClient {
	
	private static final String URL = "http://localhost:8080/api/get-status";
	private RestTemplate restTemplate = new RestTemplate();
	
	public WsResponse getLoanStatus(CustomerRequest request) {
		// call of rest service
		return restTemplate.postForObject(URL, request, WsResponse.class);
	}

}
