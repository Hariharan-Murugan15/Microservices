package com.cognizant.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.entity.Product;

@FeignClient(name = "product-service", url = "http://localhost:8082")
public interface ProductClient {
	@GetMapping("/products/{id}")
	Product getProductById(@PathVariable Long id);
}
