package com.cognizant.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "OrderService-2")
public interface OrderServiceFeignClient {
	@GetMapping("/vieworder")
	public String getOrderService();
}
