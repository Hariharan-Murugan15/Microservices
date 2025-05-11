package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.config.OrderServiceFeignClient;
import com.cognizant.entity.Student;
import com.cognizant.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@Autowired
	OrderServiceFeignClient orderServiceFeignClient;
	
	@GetMapping("/students/{id}")
	public String getStudentName(@PathVariable int  id) {
		return studentService.getStudentName(id);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/viewAllOrders")
	public String viewAllOrderFromOrderService() {
		return orderServiceFeignClient.getOrderService();
	}
}
