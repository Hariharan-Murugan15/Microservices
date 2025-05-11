package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
