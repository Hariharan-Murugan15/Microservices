package com.cts.service;

import java.util.List;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepo;

public class EmployeeService {
	private EmployeeRepo employeeRepo;

	public EmployeeService(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}
	
	
	public Employee insertEmployee(Employee emp) {
		return employeeRepo.addEmployee(emp);
	}
	
	public List<Employee> findAll(){
		return employeeRepo.findAllEmployee();
	}
	
	public int countByDept(String dept) {
		return employeeRepo.listOfEmployeeByDept(dept);
	}
}
