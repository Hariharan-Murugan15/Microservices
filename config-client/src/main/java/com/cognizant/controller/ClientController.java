package com.cognizant.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientController {
	@Value("${app.message}")
	private String mess;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${password}")
	private String pass;
	
	@GetMapping("/mess")
	public String getMess() {
		return mess + " : " + username+"   "+pass;
	}
}
