package com.cognizant.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Order;
import com.cognizant.repository.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	
	public Order saveOrder(Order order) {
		double price = order.getProduct().getPrice();
		order.setTotalPrice(price * order.getQuantity());
		order.setOrderDate(LocalDateTime.now());
		return orderRepo.save(order);
	}
	
	public Order getOrderById(Long id) {
		return orderRepo.findById(id).orElse(null);
	}
	
	public List<Order> getAllOrderForUser(Long userId){
		return orderRepo.findByUserId(userId);
	}
}
