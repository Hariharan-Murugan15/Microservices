package com.cts.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cts.entity.Employee;
import com.cts.repository.EmployeeRepo;
import com.cts.service.EmployeeService;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {
	@Mock
	private EmployeeRepo employeeRepo;
	@InjectMocks
	private EmployeeService employeeService;
	
	private Employee employee;
	private Employee empRes;
	
	@Test
	public void testAddEmployee() {
		employee = new Employee("hariharan", "ece");
		when(employeeRepo.addEmployee(employee)).thenReturn(employee);
		
		empRes = employeeService.insertEmployee(employee);
		assertEquals("hariharan", empRes.getName());
		
	}
	
	@Test
	public void testViewAllEmp() {
		List<Employee> employees = Arrays.asList(
				new Employee("hariharan", "ece"),
				new Employee("lulu", "cse")
				);
		when(employeeRepo.findAllEmployee()).thenReturn(employees);
		
		List<Employee> empRes = employeeService.findAll();
		assertEquals(2, empRes.size());
		assertEquals("lulu", empRes.get(1).getName());
	}
}
