package com.cognizant.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/controller")
public class SecurityController {
	
	@GetMapping("/home")
	public String getMethodName() {
		return "Access = ALL :D";
	}
	
	@GetMapping("/admin/addProduct")
	public String display() {
		return "Access = ADMIN :) ";
	}
	
	@GetExchange("/user/editProduct")
	public String customerDisplay() {
		return "Access = USER :>";
	}
	
}
