package com.cognizant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Employee;
import com.cognizant.repository.EmployeeRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
@Validated
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@PostMapping("/add")
	public Employee addEmployee(@Valid @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@GetMapping("/viewAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/viewAllEmployeeById/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	public EmployeeController() {
		// TODO Auto-generated constructor stub
	}
	
	@DeleteMapping("/deleteMapping/{id}")
	public String deleteEmployeeById(@PathVariable int id) {
		Optional<Employee> empOptional= employeeRepository.findById(id);
		
		
		if(empOptional.isPresent()) {
			employeeRepository.deleteById(id);
			return "Employee with "+id+" deleted successfuly";
		}
		return "No ID with "+id+" found to delete";
	}
	
	@PutMapping("/updateEmployee/{id}")
	public String updateEmployeeById(@PathVariable int id, @RequestBody Employee employee) {
		Optional<Employee> emOptional=employeeRepository.findById(id);
		if(emOptional.isEmpty()) {
			return "No Employee with "+id+"found to update ";
		}
		
		Employee updateEmployee=emOptional.get();
		updateEmployee.setAge(employee.getAge());
		updateEmployee.setDept(employee.getDept());
		updateEmployee.setName(employee.getName());
		employeeRepository.save(updateEmployee);
		return "Updated Successfully";
	}
	
	
	@ExceptionHandler(exception = MethodArgumentNotValidException.class)
	public ResponseEntity<String> handlevalidation() {
		return new ResponseEntity<>("Some Validation Failed", HttpStatus.EXPECTATION_FAILED);
	}
}
