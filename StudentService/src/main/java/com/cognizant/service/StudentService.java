package com.cognizant.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.entity.Student;

@Service
public class StudentService {
	
	List<Student> students = new ArrayList<>(
			Arrays.asList(
					new Student(1, "hari"),
					new Student(2, "niklesh")
					)
			);	
	
	
	public String getStudentName(int id) {
		int index =0;
		for(int i =0; i< students.size(); i++) {
			if(students.get(i).getRno() == id) {
				index =i;
				break;
			}
		}
		return students.get(index).getName();
	}
	
	public List<Student> getAllStudents(){
		return students;
	}
}
