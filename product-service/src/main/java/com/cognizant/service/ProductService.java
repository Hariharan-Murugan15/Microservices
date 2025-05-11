package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.entity.Product;
import com.cognizant.repository.ProductRepo;

@Service
public class ProductService {
	@Autowired
	private ProductRepo productRepo;

	public Product createProduct(Product product) {
		return productRepo.save(product);
	}
	
	public Product getProductById(Long id) {
		return productRepo.findById(id).orElse(null);
	}
	
	public ResponseEntity<String> deleteProductById(Long id){
		productRepo.deleteById(id);
		return new ResponseEntity<>("Deleted successfully..", HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteAllProducts(){
		productRepo.deleteAll();
		return new ResponseEntity<>("Deleted All Products..", HttpStatus.OK);
	}
	
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(productRepo.findAll(), HttpStatus.OK);
	}
}
