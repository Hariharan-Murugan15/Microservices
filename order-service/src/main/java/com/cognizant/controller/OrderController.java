package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Order;
import com.cognizant.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping
	public Order saveOrder(@RequestBody Order order) {
		return orderService.saveOrder(order);
	}
	
	@GetMapping("/{id}")
	public Order getOrderById(@PathVariable Long id) {
		return orderService.getOrderById(id);
	}
	
	@GetMapping("/user/{userId}")
	public List<Order> getOrdersForUser(@PathVariable Long userId){
		return orderService.getAllOrderForUser(userId);
	}
}
