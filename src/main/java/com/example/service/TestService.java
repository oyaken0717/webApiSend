package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Credit;
import com.example.domain.CreditResult;

@Service
public class TestService {

	@Autowired
	public RestTemplate restTemplate;
	
	private static final String PAYMENT_URL = "http://192.168.0.11:8080/credit-card-api/credit-card/payment";
    private static final String CANCEL_URL = "http://192.168.0.11:8080/credit-card-api/credit-card/cancel";

    public CreditResult payment(Credit credit) {
    	return restTemplate.postForObject(PAYMENT_URL, credit, CreditResult.class);
    }
    public CreditResult cancel(Credit credit) {
    	return restTemplate.postForObject(CANCEL_URL, credit, CreditResult.class);
    }
}
