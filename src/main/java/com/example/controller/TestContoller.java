package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Receive;
import com.example.domain.Send;
import com.example.service.TestService;

@Controller
@RequestMapping("")
public class TestContoller {

	@Autowired
	public TestService testService;
	
	@Bean
	RestTemplate RestTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping("")
	public String toStart() {
		return "start";
	}

	@RequestMapping("/to-send")
	public String toSend() {
		Send send = new Send();
		send.setName("とがみん");
		send.setType("human");
		System.out.println("API連携スタート");
		Receive receive = testService.check(send);
		System.out.println("API連携ゴール");
		System.out.println(receive.toString());
		return "finish";
	}
}
