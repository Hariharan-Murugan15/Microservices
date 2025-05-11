package com.cognizant.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderService2Controller {
	@GetMapping("/vieworder")
	public String viewOrder() {
		return "View order from Order Service 2";
	}
}
