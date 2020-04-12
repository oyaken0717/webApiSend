package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.domain.Credit;
import com.example.domain.CreditResult;
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
	public String toSend(Credit credit) {
		System.out.println("------------------");
		System.out.println("API連携スタート");
		
		//■ APIチェック
		CreditResult creditResult = testService.payment(credit);	
//		CreditResult creditResult = testService.cancel(credit);	
		System.out.println("API連携ゴール");
		
		System.out.println("creditResult");
		System.out.println(creditResult.getMessage());
		String message = creditResult.getMessage();
		
		if ("OK.".equals(message)) {
			System.out.println("うまくいってる");
		}else {
			System.out.println("うまくいってない");
		}
		return "finish";
	}
}
