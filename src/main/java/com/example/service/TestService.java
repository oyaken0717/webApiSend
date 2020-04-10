package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Receive;
import com.example.domain.Send;

@Service
public class TestService {

	@Autowired
	public RestTemplate restTemplate;
	
    private static final String CHECK_URL = "http://192.168.0.11:8080/webApiReceive/judge";

    public Receive check(Send send) {
    	return restTemplate.postForObject(CHECK_URL, send, Receive.class);
    }
}
