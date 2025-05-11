package com.cts.repository;

import java.util.List;

import com.cts.entity.Employee;

public interface EmployeeRepo {
	Employee addEmployee(Employee employee);
	List<Employee> findAllEmployee();
	int listOfEmployeeByDept(String dept);
}
