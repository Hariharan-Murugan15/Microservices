package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.config.OrderClient;
import com.cognizant.config.ProductClient;
import com.cognizant.entity.Order;
import com.cognizant.entity.Product;
import com.cognizant.entity.User;
import com.cognizant.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductClient productClient;
	
	@Autowired
	private OrderClient orderClient;
	
	
	@PutMapping
	public ResponseEntity<User> updateUser(User user) {
		return userService.updateUser(user);
	}
	
	
	
	@PostMapping
	public User createUse(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	
	
	@GetMapping("{userId}/product/{productId}")
	public Product getProductDetails(@PathVariable Long userId, @PathVariable Long productId){
		return productClient.getProductById(productId);
	}
	
	@GetMapping("{userId}/order/{orderId}")
	public Order getOrderDetails(@PathVariable Long userId, @PathVariable Long orderId) {
		return orderClient.getOrderById(orderId);
	}
	
	@GetMapping
	public List<User>  getAllUser() {
		return userService.getAllUser();
	}
	
	
	
	
	@DeleteMapping("{userId}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long userId){
		return userService.deleteUserById(userId);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllUsers(){
		return userService.deleteAllUsers();
	}
}
