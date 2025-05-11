package com.cognizant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="employee10")
public class Employee {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "name cannot be empty")
	@Size(min = 2, max = 10, message = "Name should have minimum characters of 2 and maximum of 10")
	private String name;
	private int age;
	private String dept;
	
	@Min(value = 0, message = "salary cannot be in negative number")
	@Max(value = 1000000, message = "salary cannot be higher than 1000000")
	private double salary;
	
	public Employee() {
		
	}
	
	public Employee(int id, String name, int age, String dept, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", dept=" + dept + ", salary=" + salary + "]";
	}
	
	
	
	
}
