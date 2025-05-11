package com.cognizant.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.cognizant.entity.Order;

@FeignClient(value = "order-service", url = "http://localhost:8083")
public interface OrderClient {
	@GetMapping("/orders/{id}")
	Order getOrderById(@PathVariable Long id);
}


//@FeignClient(value = "order-service", url = "http://localhost:8083")
//public interface OrderClient {
//    @GetMapping("/orders/{id}")
//    Order getOrderById(@PathVariable Long id);
//}

