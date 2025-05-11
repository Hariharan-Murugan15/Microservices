package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Product;
import com.cognizant.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProducts")
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Long id) {
		return productService.getProductById(id);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts(){
		return productService.getAllProducts();
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable Long id){
		return productService.deleteProductById(id);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteAllProducts(){
		return productService.deleteAllProducts();
	}
	
}
